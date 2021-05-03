package cn.bjtu.cplex;

import cn.bjtu.entiity.EmuConstraint;
import cn.bjtu.params.EmuParams;
import cn.bjtu.result.EmuResult;
import ilog.concert.IloException;
import ilog.concert.IloNumExpr;
import ilog.concert.IloNumVar;
import ilog.concert.IloNumVarType;
import ilog.cplex.IloCplex;

import java.util.ArrayList;
import java.util.List;

public class EmuCplex {
    private EmuCplex(){}

    public static EmuResult solve(EmuConstraint constraint) {
        try {
            //创建Cplex模型
            IloCplex cplex = new IloCplex();
            //导入模型参数
            EmuParams emuParams = new EmuParams(constraint);
            emuParams.emuNumber = 21;  //设置共有12各动车组，多余的会去服务虚拟列车

            //定义决策变量
            //接续0-1变量
            IloNumVar[][][] x = new IloNumVar[emuParams.nodes][emuParams.nodes][emuParams.emuNumber];
            for (int i = 0; i < emuParams.nodes; i++) {
                for (int j = 0; j < emuParams.nodes; j++) {
                    for (int m = 0; m < emuParams.emuNumber; m++) {
                        x[i][j][m] = cplex.numVar(0, 1, IloNumVarType.Int, "x[" + i + "][" + j + "][" + m + "]");
                    }
                }
            }

            //设置决策变量在某些地方的取值
            for (int i = 0; i < emuParams.nodes; i++) {
                for (int j = 0; j < emuParams.nodes; j++) {
                    if (emuParams.con[i][j] == 0) {
                        for (int m = 0; m < emuParams.emuNumber; m++) {
                            cplex.addEq(x[i][j][m], 0);
                        }
                    }
                }
            }

            //设置约束条件
            Integer deptoIndex = emuParams.trainNumber + emuParams.xuTrainNumber;

            //流平衡：  约束1 每一个动车组都需要担当运输任务
            //流平衡：  约束2 每一个动车组都需要回到动车段
            for (int m = 0; m < emuParams.emuNumber; m++) {
                IloNumExpr expr1 = cplex.diff(x[0][0][0],x[0][0][0]);
                IloNumExpr expr2 = cplex.diff(x[0][0][0],x[0][0][0]);
                for (int i = deptoIndex; i < emuParams.nodes; i++) {
                    for (int j = 0; j < emuParams.nodes; j++) {
                        /*
                        if (emuParams.con[i][j] != 0) {
                            expr1 = cplex.sum(expr1, x[i][j][m]);
                        }
                        if (emuParams.con[j][i] != 0) {
                            expr2 = cplex.sum(expr2, x[j][i][m]);
                        }
                         */
                        expr1 = cplex.sum(expr1, x[i][j][m]);
                        expr2 = cplex.sum(expr2, x[j][i][m]);
                    }
                }
                cplex.addEq(expr1, 1);//约束1
                cplex.addEq(expr2, 1);//约束2
            }

            //流平衡：  约束3  每一个动车组，每一个节点的进和发的流的总和要相等，包括虚拟列车节点，不包括动车段
            //流平衡：  约束4  每一个动车组，在每一个节点进的流的总和  不可以大于1
            for (int m = 0; m < emuParams.emuNumber; m++) {
                for (int j = 0; j < deptoIndex; j++) {
                    IloNumExpr expr1 = cplex.diff(x[0][0][1],x[0][0][1]);
                    IloNumExpr expr2 = cplex.diff(x[0][0][1],x[0][0][1]);
                    for (int i = 0; i < emuParams.nodes; i++) {
                        if (emuParams.con[i][j] != 0) {
                            expr1 = cplex.sum(expr1, x[i][j][m]);
                        }
                        if (emuParams.con[j][i] != 0) {
                            expr2 = cplex.sum(expr2, x[j][i][m]);
                        }
                    }
                    cplex.addEq(expr1, expr2);  //约束3
                    cplex.addLe(expr1, 1);    //约束4
                }
            }

            //车次必须被唯一服务约束  即出了虚拟列车节点  其他列车节点必须被服务且只能被服务一次
            for (int i = 0; i < emuParams.trainNumber; i++) {
                IloNumExpr expr = cplex.diff(x[0][0][1],x[0][0][1]);
                for (int j = 0; j < emuParams.nodes; j++) {
                    for (int m = 0; m < emuParams.emuNumber; m++) {
                        if (emuParams.con[i][j] != 0) {
                            expr = cplex.sum(expr, x[i][j][m]);
                        }
                    }
                }
                cplex.addEq(expr, 1);
            }

            //列车从哪里出来 就得回到那里去
            for (int m = 0; m < emuParams.emuNumber; m++) {
                for (int j = deptoIndex; j < emuParams.nodes; j++) {
                    IloNumExpr expr1 = cplex.diff(x[0][0][1],x[0][0][1]);
                    IloNumExpr expr2 = cplex.diff(x[0][0][1],x[0][0][1]);
                    for (int i = 0; i < emuParams.trainNumber; i++) {
                        if (emuParams.con[i][j] != 0) {
                            expr1 = cplex.sum(expr1, x[i][j][m]);
                        }
                        if (emuParams.con[j][i] != 0) {
                            expr2 = cplex.sum(expr2, x[j][i][m]);
                        }
                    }
                    cplex.addEq(expr1, expr2);
                }
            }

            //接续约束，接续需要满足接续时间
            for (int m = 0; m < emuParams.emuNumber; m++) {
                for (int i = 0; i < emuParams.trainNumber; i++) {
                    for (int j = 0; j < emuParams.trainNumber; j++) {
                        if (emuParams.con[i][j] == 1) {
                            Integer conTime = emuParams.departureTime[j] - emuParams.arriveTime[i] - emuParams.constraint.turnBackTime;
                            IloNumExpr expr = cplex.prod(conTime, x[i][j][m]);
                            cplex.addGe(expr, 0);
                        }
                    }
                }
            }

            //交路运行里程约束
            for (int m = 0; m < emuParams.emuNumber; m++) {
                IloNumExpr expr1 = cplex.diff(x[0][0][1],x[0][0][1]);
                IloNumExpr expr2 = cplex.diff(x[0][0][1],x[0][0][1]);
                for (int i = 0; i < emuParams.trainNumber; i++) {
                    for (int j = 0; j < emuParams.nodes; j++) {
                        if (j < emuParams.trainNumber || j >= deptoIndex) {
                            if (emuParams.con[i][j] == 1) {
                                expr2 = cplex.prod(x[i][j][m], emuParams.runDistance[i]);
                                expr1 = cplex.sum(expr1, expr2);
                            }
                        }
                    }
                }
                cplex.addLe(expr1, emuParams.constraint.repairDistance);
            }

            //因为时间是2天 所以不需要运行时间约束
            /*
            for (int m = 0; m < emuParams.emuNumber; m++) {
                IloNumExpr expr1 = cplex.diff(x[0][0][1],x[0][0][1]);
                IloNumExpr expr2 = cplex.diff(x[0][0][1],x[0][0][1]);
                for (int i = 0; i < emuParams.trainNumber; i++) {
                    for (int j = 0; j < emuParams.nodes; j++) {
                        if (j < emuParams.trainNumber || j >= deptoIndex) {
                            expr2 = cplex.prod(x[i][j][m], emuParams.runTime[i]);
                            expr1 = cplex.sum(expr1, expr2);
                        }
                    }
                }
                cplex.addLe(expr1, emuParams.constraint.repairTime*60);
            }
             */

            //目标函数
            IloNumExpr obj1 = cplex.diff(x[0][0][0], x[0][0][0]);
            IloNumExpr obj2 = cplex.diff(x[0][0][0], x[0][0][0]);
            IloNumExpr obj3 = cplex.diff(x[0][0][0], x[0][0][0]);
            for (int m = 0; m < emuParams.emuNumber; m++) {
                for (int i = deptoIndex; i < emuParams.nodes; i++) {
                    for (int j = 0; j < emuParams.trainNumber; j++) {
                        if (emuParams.con[i][j] == 1) {
                            obj1 = cplex.sum(obj1, cplex.prod(x[i][j][m], emuParams.departureTime[j]));
                        }
                    }
                }
                for (int i = 0; i < emuParams.trainNumber; i++) {
                    for (int j = 0; j < emuParams.trainNumber; j++) {
                        if (emuParams.con[i][j] == 1) {
                            obj2 = cplex.sum(obj2, cplex.prod(x[i][j][m], emuParams.departureTime[j] - emuParams.arriveTime[i]));
                        }
                    }
                }
                for (int i = 0; i < emuParams.trainNumber; i++) {
                    for (int j = deptoIndex; j < emuParams.nodes; j++) {
                        if (emuParams.con[i][j] == 1) {
                            obj3 = cplex.sum(obj3, cplex.prod(x[i][j][m], 24 * 60 * emuParams.cyc - emuParams.arriveTime[i]));
                        }
                    }
                }
            }
            double sumRumTime = 0;
            for (int i = 0; i < emuParams.trainNumber; i++) {
                sumRumTime = sumRumTime + emuParams.runTime[i];
            }
            //加上所有车次的运行时间,如果在除以 24*60*天数就是  实际需要的 动车组数了
            obj1 = cplex.sum(obj1, sumRumTime);

            cplex.addMinimize(cplex.sum(obj1, cplex.sum(obj2, obj3)));

            if (cplex.solve()) {
                //计算成功
                List<List<String>> routings = new ArrayList<>();
                List<Integer> runDistances = new ArrayList<>();
                for (int m = 0; m < emuParams.emuNumber; m++) {
                    List<String> rout = new ArrayList<>();
                    Integer runDistance = 0;
                    for (int i = deptoIndex; i < emuParams.nodes; i++) {
                        for (int j = 0; j < emuParams.nodes; j++) {
                            if (cplex.getValue(x[i][j][m]) == 1) {
                                if (i == deptoIndex) {
                                    rout.add("A");
                                } else if (i == deptoIndex + 1) {
                                    rout.add("B");
                                } else if (i == deptoIndex + 2) {
                                    rout.add("C");
                                }
                                rout.add(j+"");
                            }
                        }
                    }
                    for (int i = 0; i < deptoIndex; i++) {
                        for (int j = 0; j < emuParams.nodes; j++) {
                            if (cplex.getValue(x[i][j][m]) == 1) {
                                if (j < deptoIndex) {
                                    rout.add("" + i);
                                    rout.add("" + j);
                                    if (i < emuParams.trainNumber) {
                                        runDistance = runDistance + emuParams.runDistance[i];
                                    }
                                } else {
                                    rout.add("" + i);
                                    if (i < emuParams.trainNumber) {
                                        runDistance = runDistance + emuParams.runDistance[i];
                                    }
                                    if (j == deptoIndex) {
                                        rout.add("A");
                                    } else if (j == deptoIndex + 1) {
                                        rout.add("B");
                                    } else if (j == deptoIndex + 2) {
                                        rout.add("C");
                                    }
                                }
                            }
                        }
                    }
                    routings.add(rout);
                    runDistances.add(runDistance);
                }
                routings = castRountings(routings);
                return new EmuResult(routings,runDistances);
            } else {
                //计算失败
                return new EmuResult(false);
            }
        } catch (IloException e) {
            e.printStackTrace();
        }
        //计算失败
        return new EmuResult(false);
    }

    private static List<List<String>> castRountings(List<List<String>> routings) {
        List<List<String>> results = new ArrayList<>();
        for (List<String> routing : routings) {
            List<String> result = new ArrayList<>();
            //创建被接续列车 和接续列车
            List<String> r1 = new ArrayList<>();//被接续列车
            List<String> r2 = new ArrayList<>();//接续列车
            for (int i = 0; i < routing.size(); i = i + 2) {
                r1.add(routing.get(i));
            }
            for (int i = 1; i < routing.size(); i = i + 2) {
                r2.add(routing.get(i));
            }
            result.add(r1.get(0));
            result.add(r2.get(0));
            Integer index = r1.indexOf(r2.get(0));
            while (index >= 0) {
                result.add(r2.get(index));
                if (r2.get(index) == "A" || r2.get(index) == "B" || r2.get(index) == "C") {
                    break;
                }
                index = r1.indexOf(r2.get(index));
            }
            results.add(result);
        }
        return results;
    }

}
