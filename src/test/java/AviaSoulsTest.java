import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AviaSoulsTest {

    @Test
    public void showExpensiveTicket() {
        Ticket ticket1 = new Ticket("Ekb", "Moscow", 100, 10, 00);
        Ticket ticket2 = new Ticket("Spb", "Moscow", 300, 11, 15);
        AviaSouls souls = new AviaSouls();
        souls.add(ticket1);
        souls.add(ticket2);
        int expected = -1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void sortingTicketWithThree() {
        Ticket ticket1 = new Ticket("Ekb", "Moscow", 100, 10, 12);
        Ticket ticket2 = new Ticket("Spb", "Moscow", 300, 11, 15);
        Ticket ticket3 = new Ticket("Moscow", "Ekb", 100, 12, 14);
        Ticket ticket4 = new Ticket("Spb", "Moscow", 700, 13, 18);
        Ticket ticket5 = new Ticket("Spb", "Moscow", 900, 18, 20);
        AviaSouls souls = new AviaSouls();
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        Ticket[] expected = {ticket2, ticket4, ticket5};
        Ticket[] actual = souls.search("Spb", "Moscow");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortingTicketWithOne() {
        Ticket ticket1 = new Ticket("Ekb", "Moscow", 100, 10, 12);
        Ticket ticket2 = new Ticket("Spb", "Moscow", 300, 11, 15);
        Ticket ticket3 = new Ticket("Moscow", "Ekb", 100, 12, 14);
        Ticket ticket4 = new Ticket("Spb", "Moscow", 700, 13, 18);
        Ticket ticket5 = new Ticket("Spb", "Moscow", 900, 18, 20);
        AviaSouls souls = new AviaSouls();
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        Ticket[] expected = {ticket3};
        Ticket[] actual = souls.search("Moscow", "Ekb");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortingTicketWithZero() {
        Ticket ticket1 = new Ticket("Ekb", "Moscow", 100, 10, 12);
        Ticket ticket2 = new Ticket("Spb", "Moscow", 300, 11, 15);
        Ticket ticket3 = new Ticket("Moscow", "Ekb", 100, 12, 14);
        Ticket ticket4 = new Ticket("Spb", "Moscow", 700, 13, 18);
        Ticket ticket5 = new Ticket("Spb", "Moscow", 900, 18, 20);
        AviaSouls souls = new AviaSouls();
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        Ticket[] expected = {};
        Ticket[] actual = souls.search("Moscow", "Spb");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void showTicketTimeComparator() {
        Ticket ticket1 = new Ticket("Ekb", "Moscow", 100, 10, 11);//1
        Ticket ticket2 = new Ticket("Spb", "Moscow", 300, 11, 15);//4
        Ticket ticket3 = new Ticket("Moscow", "Ekb", 100, 12, 14);//2
        Ticket ticket4 = new Ticket("Spb", "Moscow", 700, 13, 18);//5
        Ticket ticket5 = new Ticket("Spb", "Moscow", 900, 18, 20);//2
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        int expected = -1;
        int actual = timeComparator.compare(ticket1, ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void sortingTicketTimeComparatorWithThree() {
        Ticket ticket1 = new Ticket("Ekb", "Moscow", 100, 10, 11);//1
        Ticket ticket2 = new Ticket("Spb", "Moscow", 300, 11, 15);//4
        Ticket ticket3 = new Ticket("Moscow", "Ekb", 100, 12, 14);//2
        Ticket ticket4 = new Ticket("Spb", "Moscow", 700, 13, 18);//5
        Ticket ticket5 = new Ticket("Spb", "Moscow", 900, 18, 20);//2
        AviaSouls souls = new AviaSouls();
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket[] expected = {ticket5, ticket2, ticket4};
        Ticket[] actual = souls.searchAndSortBy("Spb", "Moscow", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortingTicketTimeComparatorWithOne() {
        Ticket ticket1 = new Ticket("Ekb", "Moscow", 100, 10, 11);//1
        Ticket ticket2 = new Ticket("Spb", "Moscow", 300, 11, 15);//4
        Ticket ticket3 = new Ticket("Moscow", "Ekb", 100, 12, 14);//2
        Ticket ticket4 = new Ticket("Spb", "Moscow", 700, 13, 18);//5
        Ticket ticket5 = new Ticket("Spb", "Moscow", 900, 18, 20);//2
        AviaSouls souls = new AviaSouls();
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket[] expected = {ticket3};
        Ticket[] actual = souls.searchAndSortBy("Moscow", "Ekb", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortingTicketTimeComparatorWithZero() {
        Ticket ticket1 = new Ticket("Ekb", "Moscow", 100, 10, 11);//1
        Ticket ticket2 = new Ticket("Spb", "Moscow", 300, 11, 15);//4
        Ticket ticket3 = new Ticket("Moscow", "Ekb", 100, 12, 14);//2
        Ticket ticket4 = new Ticket("Spb", "Moscow", 700, 13, 18);//5
        Ticket ticket5 = new Ticket("Spb", "Moscow", 900, 18, 20);//2
        AviaSouls souls = new AviaSouls();
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket[] expected = {};
        Ticket[] actual = souls.searchAndSortBy("Spb", "Ekb", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }
}
