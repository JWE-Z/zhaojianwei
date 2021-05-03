package cn.bjtu.cplex;

import cn.bjtu.entiity.Constraint;
import cn.bjtu.params.DiagramParams;
import cn.bjtu.result.DiagramResult;
import ilog.concert.IloException;
import ilog.concert.IloNumExpr;
import ilog.concert.IloNumVar;
import ilog.concert.IloNumVarType;
import ilog.cplex.IloCplex;

import java.util.ArrayList;
import java.util.List;

public class DiagramCplex {

    public static DiagramResult solve(Constraint constraint) {
        try {
            //先创建一个Cplex对象
            IloCplex cplex = new IloCplex();
            //设置求解精度
            //cplex.setParam(IloCplex.Param.Simplex.Tolerances.Optimality, 1e-9);
            //cplex.setParam(IloCplex.Param.MIP.Tolerances.MIPGap, 0.8);
            //CPX_PARAM_INTSOLLIM
            //cplex.setParam(IloCplex.Param.MIP.Limits.Solutions,1);//限定出现第一个可行解，终止求解\
            //cplex.setParam(IloCplex.Param.MIP.Limits.Nodes, 3);//求解3个节点，终止算法
            //cplex.setParam(IloCplex.Param.TimeLimit, 60);//求解时间为1min，终止算法
            //设置求解时间，3600 s
            //cplex.setParam(IloCplex.DoubleParam.TimeLimit, 60*5);
            //设置输出，不要让cplex输出那些乱起八糟的东西，太乱了
            //cplex.setOut(null);

            //导入模型参数
            DiagramParams diagramParams = new DiagramParams(constraint);
            diagramParams.trainNumbers = 5;

            //定义决策变量
            //x(i,n) 表示列车i在车站n的出发时间
            IloNumVar[][] x = new IloNumVar[diagramParams.trainNumbers][diagramParams.stationNumbers];
            //给 x(i,n) 发媳妇！
            for (int i = 0; i  < diagramParams.trainNumbers; i++) {
                x[i][0] = cplex.numVar(0, 120, IloNumVarType.Int, "x[" + i + "][" + 0 + "]");
            }
            for (int i = 0; i < diagramParams.trainNumbers; i++) {
                for (int n = 1; n < diagramParams.stationNumbers; n++) {
                    x[i][n] = cplex.numVar(0, 300, IloNumVarType.Int, "x[" + i + "][" + n + "]");
                }
            }

            //y(i,n) 表示列车i在车站n的到达时间
            IloNumVar[][] y = new IloNumVar[diagramParams.trainNumbers][diagramParams.stationNumbers];
            //给y(i,n)发媳妇！
            for (int i = 0; i < diagramParams.trainNumbers; i++) {
                for (int n = 0; n < diagramParams.stationNumbers; n++) {
                    y[i][n] = cplex.numVar(0, 300, IloNumVarType.Int, "y[" + i + "][" + n + "]");
                }
            }

            //s(i,n) 表示列车i在车站n的停站时间
            IloNumVar[][] s = new IloNumVar[diagramParams.trainNumbers][diagramParams.stationNumbers];
            //给 s(i,n) 发媳妇！
            for (int i = 0; i < diagramParams.trainNumbers; i++) {
                for (int n = 0; n < diagramParams.stationNumbers; n++) {
                    s[i][n] = cplex.numVar(0,(int) diagramParams.constraint.stopTimeMax, IloNumVarType.Int, "s[" + i + "][" + n + "]");
                }
            }

            //p(i,n) 表示列车i在车站n 是否停站
            IloNumVar[][] p = new IloNumVar[diagramParams.trainNumbers][diagramParams.stationNumbers];
            //给 p(i,n) 发媳妇！
            for (int i = 0; i < diagramParams.trainNumbers; i++) {
                for (int n = 0; n < diagramParams.stationNumbers; n++) {
                    p[i][n] = cplex.numVar(0,1, IloNumVarType.Int, "p[" + i + "][" + n + "]");
                }
            }

            //o(i,j,n) 表示 列车i 在 车站n 是否越行 列车j
            IloNumVar[][][] o = new IloNumVar[diagramParams.trainNumbers][diagramParams.trainNumbers][diagramParams.stationNumbers];
            //给 o(i,j,n) 发媳妇！
            for (int i = 0; i < diagramParams.trainNumbers; i++) {
                for (int j = 0; j < diagramParams.trainNumbers; j++) {
                    for (int n = 0; n < diagramParams.stationNumbers; n++) {
                        o[i][j][n] = cplex.numVar(0, 1, IloNumVarType.Int, "o[" + i + "][" + j + "][" + n + "]");
                    }
                }
            }


            //r(i,n) 表示列车i在车站n和车站n+1之间运行时  冗余的时间为多少  最大冗余时间是网页给定的
            //运行冗余时间
            IloNumVar[][] r = new IloNumVar[diagramParams.trainNumbers][diagramParams.stationNumbers];
            //给 r(i,n) 发媳妇！
            for (int i = 0; i < diagramParams.trainNumbers; i++) {
                for (int n = 0; n < diagramParams.stationNumbers; n++) {
                    r[i][n] = cplex.numVar(0,(int)diagramParams.constraint.runRedundancyTime, IloNumVarType.Int, "r[" + i + "][" + n + "]");
                }
            }



            //定义表达式
            //x[0][0]=0  表示第一列列车的出发时间为0
            cplex.addEq(x[0][0], 0);

            //x[][end]=0 让所有的列车在最后一个车站的出发时间为0 ，无实际意义
            for (int i = 0; i < diagramParams.trainNumbers; i++) {
                cplex.addEq(x[i][diagramParams.stationNumbers - 1], 0);
            }

            //y[][0]=0 让所有列车在第一个车站的到达时间为0,无实际意义
            for (int i = 0; i < diagramParams.trainNumbers; i++) {
                cplex.addEq(y[i][0], 0);
            }

            //让i==j 时的越行变量o  为0
            //让 第一个和最后一个车站的越行变量都为0
            for (int i = 0; i < diagramParams.trainNumbers; i++) {
                for (int j = 0; j < diagramParams.trainNumbers; j++) {
                    for (int n = 0; n < diagramParams.stationNumbers; n++) {
                        if (i == j || n == 0 || n == diagramParams.stationNumbers - 1) {
                            cplex.addEq(o[i][j][n], 0);
                        }
                    }
                }
            }

            //车站n后的区间冗余时间为0；
            for (int i = 0; i < diagramParams.trainNumbers; i++) {
                cplex.addEq(r[i][diagramParams.stationNumbers - 1], 0);
            }

            //让停站时间在车站1 和车站最后都为0；
            for (int i = 0; i < diagramParams.trainNumbers; i++) {
                cplex.addEq(s[i][0], 0);
                cplex.addEq(s[i][diagramParams.stationNumbers - 1], 0);
            }

            //创建一个空的表达式然后去填充它,运行连续约束1
            //创建运行连续约束
            for (int i = 0; i < diagramParams.trainNumbers; i++) {
                for (int n = 0; n < diagramParams.stationNumbers - 1; n++) {
                    IloNumExpr expr1 = cplex.numExpr();
                    IloNumExpr expr2 = cplex.numExpr();
                    IloNumExpr expr3 = cplex.numExpr();
                    expr3 = cplex.prod(diagramParams.constraint.additionalStartingTime,p[i][n]);
                    expr1 = cplex.sum(x[i][n], expr3);
                    expr2 = cplex.prod(diagramParams.constraint.additionalParkingTime,p[i][n+1]);
                    expr1 = cplex.sum(expr1,expr2);
                    expr1 = cplex.sum(expr1,diagramParams.intervalOperationTime[n]);
                    expr1 = cplex.sum(expr1,r[i][n]);
                    cplex.addEq(y[i][n+1], expr1);
                }
            }

            //列车运行连续约束，即出发时间等于到达时间加停站时间
            for (int i = 0; i < diagramParams.trainNumbers; i++) {
                for (int n = 1; n < diagramParams.stationNumbers - 1; n++) {
                    IloNumExpr expr1 = cplex.sum(y[i][n], s[i][n]);
                    cplex.addEq(x[i][n], expr1);
                }
            }

            //列车运行连续约束，车次大的要比车次小的 在首站 先发车
            for (int i = 0; i < diagramParams.trainNumbers - 1; i++) {
                IloNumExpr expr1 = cplex.diff(x[i + 1][0], diagramParams.constraint.departureInterval);
                cplex.addLe(x[i][0],expr1);
            }

            //从约束参数中取出既定方案集合，然后创建必须停站约束
            for (Integer[] point : diagramParams.E) {
                if (point[0] < diagramParams.trainNumbers) {
                    cplex.addEq(p[point[0]][point[1]], 1);
                }
            }

            //创建停站时分约束 1
            for (int i = 0; i < diagramParams.trainNumbers; i++) {
                for (int n = 1; n < diagramParams.stationNumbers - 1; n++) {
                    IloNumExpr expr2 = cplex.prod(p[i][n], diagramParams.constraint.stopTimeMin);
                    cplex.addGe(s[i][n], expr2);
                }
            }

            //创建停站时分约束 2
            for (int i = 0; i < diagramParams.trainNumbers; i++) {
                for (int n = 1; n < diagramParams.stationNumbers - 1; n++) {
                    IloNumExpr expr2 = cplex.prod(p[i][n], diagramParams.constraint.stopTimeMax);
                    cplex.addLe(s[i][n], expr2);
                }
            }

            //创建到达间隔约束
            for (int i = 0; i < diagramParams.trainNumbers; i++) {
                for (int j = 0; j < diagramParams.trainNumbers; j++) {
                    for (int n = 1; n < diagramParams.stationNumbers; n++) {
                        if (i != j) {
                            IloNumExpr expr1 = cplex.diff(y[i][n], y[j][n]);
                            expr1 = cplex.abs(expr1);
                            cplex.addGe(expr1, diagramParams.constraint.arrivalInterval);
                        }
                    }
                }
            }

            //周期间隔要求
            for (int n = 0; n < diagramParams.stationNumbers; n++) {
                IloNumExpr[] xin = new IloNumExpr[diagramParams.trainNumbers];
                IloNumExpr[] yin = new IloNumExpr[diagramParams.trainNumbers];
                for (int i = 0; i < diagramParams.trainNumbers; i++) {
                    xin[i] = x[i][n];
                    yin[i] = y[i][n];
                }
                IloNumExpr expr1 = cplex.sum(cplex.min(xin),120);
                expr1 = cplex.diff(expr1,cplex.max(xin));
                cplex.addGe(expr1, diagramParams.constraint.departureInterval);
                IloNumExpr expr2 = cplex.sum(cplex.min(yin),120);
                expr2 = cplex.diff(expr2, cplex.max(yin));
                cplex.addGe(expr2, diagramParams.constraint.arrivalInterval);
            }


            //创建出发间隔约束
            for (int i = 0; i < diagramParams.trainNumbers; i++) {
                for (int j = 0; j < diagramParams.trainNumbers; j++) {
                    for (int n = 0; n < diagramParams.stationNumbers-1; n++) {
                        if (i != j) {
                            IloNumExpr expr1 = cplex.diff(x[i][n], x[j][n]);
                            expr1 = cplex.abs(expr1);
                            cplex.addGe(expr1, diagramParams.constraint.departureInterval);
                        }
                    }
                }
            }

            //创建越行约束 1
            //每个列车在一个车站只能被越行几次
            //次数由网页输入，默认1次
            for (int j = 0; j < diagramParams.trainNumbers; j++) {
                for (int n = 1; n < diagramParams.stationNumbers - 1; n++) {
                    IloNumExpr expr1 = cplex.diff(o[0][0][0], o[0][0][0]);
                    for (int i = 0; i < diagramParams.trainNumbers; i++) {
                        if (i != j) {
                            expr1 = cplex.sum(expr1, o[i][j][n]);
                        }
                    }
                    cplex.addLe(expr1, diagramParams.constraint.beOvertaken);
                }
            }

            //创建越行约束 2
            //每个列车在每个车站最多只能越行几次。
            //次数由网页输入，默认1次
            for (int i = 0; i < diagramParams.trainNumbers; i++) {
                for (int n = 1; n < diagramParams.stationNumbers - 1; n++) {
                    IloNumExpr expr1 = cplex.numExpr();
                    expr1 = cplex.diff(o[0][0][0],o[0][0][0]);
                    for (int j = 0; j < diagramParams.trainNumbers; j++) {
                        if (i != j) {
                            expr1 = cplex.sum(expr1, o[i][j][n]);
                        }
                    }
                    cplex.addLe(expr1, diagramParams.constraint.overtaken);
                }
            }


            /*
            //创建越行约束 3
            //当x-x * y-y =1 时，决策变量为1
            //其他时候为 0
            for (int i = 0; i < diagramParams.trainNumbers; i++) {
                for (int j = 0; j < diagramParams.trainNumbers; j++) {
                    for (int n = 1; n < diagramParams.stationNumbers - 1; n++) {
                        if (i != j) {
                            //x-x > 0  为1
                            IloNumExpr expr1 = cplex.diff(x[j][n], x[i][n]);
                            double[] points = new double[]{0, 0};
                            double[] slopes = new double[]{0, 9, 0};
                            double[] slopes1 = new double[]{0, 1, 0};
                            expr1 = cplex.piecewiseLinear(expr1, points, 0, 2, slopes, 0, -1, -5);
                            //y-y < 0  为1
                            IloNumExpr expr2 = cplex.diff(y[i][n], y[j][n]);
                            expr2 = cplex.piecewiseLinear(expr2, points, 0, 2, slopes, 0, -1, -5);
                            //同时满足x-x > 0  和  y-y < 0  表示越行成功
                            expr1 = cplex.sum(expr1, expr2);
                            expr1 = cplex.piecewiseLinear(expr1, points, 0, 2, slopes1, 0, -1, 0);
                            cplex.addEq(o[i][j][n], expr1);
                        }
                    }
                }
            }
            */

            //目标函数表达式
            IloNumExpr obj = cplex.diff(y[0][diagramParams.stationNumbers - 1], x[0][0]);
            for (int i = 1; i < diagramParams.trainNumbers; i++) {
                IloNumExpr expr1 = cplex.diff(y[i][diagramParams.stationNumbers - 1],x[i][0]);
                obj = cplex.sum(obj, expr1);
            }
            //松弛项
            //当x-x * y-y =1 时，决策变量为1
            //其他时候为 0
            IloNumExpr songchi = cplex.diff(x[0][0],x[0][0]);
            for (int i = 0; i < diagramParams.trainNumbers; i++) {
                for (int j = 0; j < diagramParams.trainNumbers; j++) {
                    for (int n = 1; n < diagramParams.stationNumbers - 1; n++) {
                        if (i != j) {
                            //x-x > 0  为1
                            IloNumExpr expr1 = cplex.diff(x[j][n], x[i][n]);
                            double[] points = new double[]{0, 0};
                            double[] slopes = new double[]{0, 9, 0};
                            double[] slopes1 = new double[]{0, 1, 0};
                            expr1 = cplex.piecewiseLinear(expr1, points, 0, 2, slopes, 0, -1, -5);
                            //y-y < 0  为1
                            IloNumExpr expr2 = cplex.diff(y[i][n], y[j][n]);
                            expr2 = cplex.piecewiseLinear(expr2, points, 0, 2, slopes, 0, -1, -5);
                            //同时满足x-x > 0  和  y-y < 0  表示越行成功
                            expr1 = cplex.sum(expr1, expr2);
                            expr1 = cplex.piecewiseLinear(expr1, points, 0, 2, slopes1, 0, -1, 0);
                            expr1 = cplex.diff(o[i][j][n], expr1);
                            expr1 = cplex.abs(expr1);
                            expr1 = cplex.prod(expr1,200);
                            songchi = cplex.sum(expr1, songchi);
                        }
                    }
                }
            }


            cplex.addMinimize(cplex.sum(obj, songchi));
            //cplex.addMinimize(obj);



            //如果求解成功，输出成功，否则输出求解失败
            boolean result = cplex.solve();
            if (result) {
                List<Integer[]> xResults = new ArrayList<>();
                List<Integer[]> yResults = new ArrayList<>();
                List<Integer[]> sResults = new ArrayList<>();
                for (int i = 0; i < diagramParams.trainNumbers; i++) {
                    //写入x，y
                    Integer[] xResult = new Integer[diagramParams.stationNumbers - 1];
                    Integer[] yResult = new Integer[diagramParams.stationNumbers - 1];
                    for (int n = 0; n < diagramParams.stationNumbers - 1; n++) {
                        xResult[n] = (int) cplex.getValue(x[i][n]);
                        yResult[n] = (int) cplex.getValue(y[i][n + 1]);
                    }
                    xResults.add(xResult);
                    yResults.add(yResult);
                    //写入s
                    Integer[] sResult = new Integer[diagramParams.stationNumbers - 2];
                    for (int n = 1; n < diagramParams.stationNumbers - 1; n++) {
                        sResult[n-1] = (int) cplex.getValue(s[i][n]);
                    }

                    sResults.add(sResult);
                }
                return new DiagramResult(xResults, yResults, sResults, true);
            } else {
                //返回求解出错
                return new DiagramResult(false);
            }
        } catch (IloException e) {
            e.printStackTrace();
        }
        //返回求解出错
        return new DiagramResult(false);
    }
}
