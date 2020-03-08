interface Strategy {
    void solve();
}
@SuppressWarnings("ALL")
abstract class StrategySolution implements Strategy {
       public void solve() {
        start();
        while (nextTry() && !isSolution()) {}
        stop();
    }

    abstract void start();
    abstract boolean nextTry();
    abstract boolean isSolution();
    abstract void stop();
}

class FOO extends StrategySolution {
    private int state = 1;

    protected void start() {
        System.out.print("Start  ");
    }

    protected void stop() {
        System.out.println("Stop");
    }

    protected boolean nextTry() {
        System.out.print("NextTry-" + state++ + "  ");
        return true;
    }

    protected boolean isSolution() {
        System.out.print("IsSolution-" + (state == 3) + "  ");
        return (state == 3);
    }
}

abstract class StrategySearch implements Strategy {
        public void solve() {
        while (true) {
            preProcess();
            if (search()) {
                break;
            }
            postProcess();
        }
    }

    abstract void preProcess();
    abstract boolean search();
    abstract void postProcess();
}

@SuppressWarnings("ALL")
class BAR extends StrategySearch {
    private int state = 1;

    protected void preProcess()  {
        System.out.print("PreProcess  ");
    }

    protected void postProcess() {
        System.out.print("PostProcess  ");
    }

    protected boolean search() {
        System.out.print("Search-" + state++ + "  ");
        return state == 3 ? true : false;
    }
}
public class StrategyDemo {
	private static void execute(Strategy strategy) {
        strategy.solve();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Strategy[] algorithms = {new FOO(), new BAR()};
	        for (Strategy algorithm : algorithms) {
	            execute(algorithm);
	        }
	    }
	}


