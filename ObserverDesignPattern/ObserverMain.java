package ObserverDesignPattern;

import java.util.ArrayList;
import java.util.List;

 interface ISubscriber{
        void update();
    }

    // Observable interface: a YouTube channel interface
    interface IChannel{
        void subscribe(ISubscriber subscriber);
        void unSubscribe(ISubscriber subscriber);
        void notifySubscribers();
    }
    // Concrete Subject: a YouTube channel that observers can subscribe to
    class Channel implements IChannel{
        private List<ISubscriber> subscribers;
        private String latesVideo = null;
        private String channelName; 

        public Channel(String name){
            this.channelName = name;
            this.subscribers = new ArrayList<>();
        }

        @Override
        public void subscribe(ISubscriber s){
            if(!subscribers.contains(s)){
                subscribers.add(s);
            }
        }
        @Override
        public void unSubscribe(ISubscriber s){
            subscribers.remove(s);
        }
        @Override
        public void notifySubscribers(){
            System.out.println("\nNotifying Subscribers...");
            for(ISubscriber s: subscribers){
                
                s.update();
            }
        }

        public void uploadVideo(String title){
            latesVideo = title;
            System.out.println("New video uploaded on " + channelName + ": " + title);
            notifySubscribers();
        }

        public String getLatestVideo(){
            return "\n Checkout the latest video: " + latesVideo + " on " + channelName;
        }
    }

    // Concrete Observer: represents a subscriber to the channel
    class Subscriber implements ISubscriber{
        private String name;
        private Channel channel;

        public Subscriber(String name, Channel channel){
            this.name = name;
            this.channel = channel;
        }

        @Override
        public void update(){
            System.out.println("Hey " + name + ", " + channel.getLatestVideo());
        }
    }

public class ObserverMain {
    public static void main(String[] args) {
        // Create a YouTube channel
        Channel techChannel = new Channel("TechExplained");

        Subscriber bipin  = new Subscriber("Bipin", techChannel);
        Subscriber vishal = new Subscriber("Vishal", techChannel);

        techChannel.subscribe(bipin);
        techChannel.subscribe(vishal);
        techChannel.uploadVideo("null Pointer Exception in Java Explained!");

        techChannel.unSubscribe(vishal);
        techChannel.uploadVideo("Understanding Observer Design Pattern");
        
    }
}
