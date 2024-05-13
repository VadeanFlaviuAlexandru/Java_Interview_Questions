package CodingProblems.DesignPatterns.BehavioralPatterns;

import java.util.*;

import static CodingProblems.DesignPatterns.BehavioralPatterns.ObserverPattern.Event.NEW_ITEM;
import static CodingProblems.DesignPatterns.BehavioralPatterns.ObserverPattern.Event.SALE;

public class ObserverPattern {
    public enum Event {

        NEW_ITEM,
        SALE

    }
    public interface Listener {

        void update(Event eventType);

    }

    // ----------------------------------------------

    public record EmailMsgListener(String email) implements Listener {

        @Override
        public void update(Event eventType) {
            // Actually send the mail
            System.out.println("Sending mail to " + email + " concerning " + eventType);
        }

    }
    public record MobileAppListener(String username) implements Listener {

        @Override
        public void update(Event eventType) {
            // Actually send the push notification to username
            System.out.println("Sending mobile app notification to " + username + " concerning " + eventType);
        }

    }

    // ----------------------------------------------

    public class Store {

        private final NotificationService notificationService;

        public Store() {
            notificationService = new NotificationService();
        }

        public void newItemPromotion() {
            notificationService.notifyCustomers(NEW_ITEM);
        }

        public void salePromotion() {
            notificationService.notifyCustomers(SALE);
        }

        public NotificationService getService() {
            return notificationService;
        }

    }
    public class NotificationService {

        private final Map<Event, List<Listener>> customers;

        public NotificationService() {
            customers = new HashMap<>();
            Arrays.stream(Event.values()).forEach(event -> customers.put(event, new ArrayList<>()));
        }

        public void subscribe(Event eventType, Listener listener) {
            customers.get(eventType).add(listener);
        }

        public void unsubscribe(Event eventType, Listener listener) {
            customers.get(eventType).remove(listener);
        }

        public void notifyCustomers(Event eventType) {
            customers.get(eventType).forEach(listener -> listener.update(eventType));
        }

    }

    public void main(String[] args) {

        Store store = new Store();
        store.getService().subscribe(NEW_ITEM, new EmailMsgListener("geekific@like.com"));
        store.getService().subscribe(SALE, new EmailMsgListener("geekific@like.com"));
        store.getService().subscribe(SALE, new EmailMsgListener("geekific@subs.com"));
        store.getService().subscribe(NEW_ITEM, new MobileAppListener("GeekificLnS"));

        store.newItemPromotion();

        System.out.println("==========================================");

        store.salePromotion();

        System.out.println("==========================================");

        store.getService().unsubscribe(SALE, new EmailMsgListener("geekific@like.com"));
        store.salePromotion();

    }
}
