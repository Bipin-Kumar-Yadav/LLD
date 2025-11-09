package MusicPlayerApplication.managers;

import MusicPlayerApplication.enums.PlayStrategyType;
import MusicPlayerApplication.strategies.CustomQueueStrategy;
import MusicPlayerApplication.strategies.PlayStrategy;
import MusicPlayerApplication.strategies.RandomPlayStrategy;
import MusicPlayerApplication.strategies.SequentialPlayStrategy;

public class StrategyManager {
    private static StrategyManager instance = null;
    private SequentialPlayStrategy sequentialPlayStrategy;
    private RandomPlayStrategy randomPlayStrategy;
    private CustomQueueStrategy customQueueStrategy;

    private StrategyManager(){
        sequentialPlayStrategy = new SequentialPlayStrategy();
        randomPlayStrategy = new RandomPlayStrategy();
        customQueueStrategy = new CustomQueueStrategy();
    }

    public static StrategyManager getInstance(){
        if(instance == null){
            instance = new StrategyManager();
        }
        return instance;
    }

    public PlayStrategy getStrategy(PlayStrategyType strategyType){
        switch(strategyType){
            case SEQUENTIAL:
                return sequentialPlayStrategy;
            case RANDOM:
                return randomPlayStrategy;
            case CUSTOM_QUEUE:
                return customQueueStrategy;
            default:
                throw new IllegalArgumentException("Invalid Strategy Type");
        }
    }
}
