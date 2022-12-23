import java.util.Scanner;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Main {
    static class Task {
        int number;
        String firstDate;
        String endDate;
        String name;
        String desc;

        boolean done = false;

    } // класс описывающий задание
    static String getDate(){
        Scanner in = new Scanner(System.in);
        String dt = "";
        int y = 0;
        while (y < 1000) {
            System.out.println("Input year");
            String st = in.nextLine();
            try {
                y = Integer.valueOf(st);
            } catch (NumberFormatException e) {
                System.err.println("Wrong format");
            }
        }
        dt = Integer.toString(y) + "\\";
        int m = 0;
        while ((m <= 0) || (m  > 12)) {
            System.out.println("Input month");
            String st = in.nextLine();
            try {
                m = Integer.valueOf(st);
            } catch (NumberFormatException e) {
                System.err.println("Wrong format");
            }
        }
        dt = dt + Integer.toString(m) + "\\";
        int d = 0;
        while ((d <= 0) || (d > 31)) {
            System.out.println("Input day");
            String st = in.nextLine();
            try {
                d = Integer.valueOf(st);
            } catch (NumberFormatException e) {
                System.err.println("Wrong format");
            }
        }
        dt = dt + Integer.toString(d);
        return dt;
    } // ввод даты с клавиатуры

    static class Schedule {
        ArrayList<Task> lsTask = new ArrayList<>(); // список, где хранятся задания

        int indx = 1; // номер для новой задачи
         void add() {
             Scanner in = new Scanner(System.in);
             Task tmp = new Task();
             tmp.number = indx;
             indx = indx + 1;
             SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd"); 
             Date date = new Date();
             //сейчас не используется, потому что ввожу дату через getDate
             // но так можно было бы дату создания автоматически ставить
             System.out.println("Creation date");
             tmp.firstDate = getDate();
             System.out.println("Expiration date");
             tmp.endDate = getDate();
             System.out.println("Name");
             tmp.name = in.nextLine();
             System.out.println("Description");
             tmp.desc = in.nextLine();
             lsTask.add(tmp);
         } // добавления задачи в список
         void del(){
             int i= 0;
             Scanner in = new Scanner(System.in);
             while ((i <= 0) || (i >= indx)) {
                 System.out.println("Task number to delete");
                 String st = in.nextLine();
                 try {
                     i = Integer.valueOf(st);
                 } catch (NumberFormatException e) {
                     System.err.println("Wrong format");
                 }
             }
             for (int j = 0; j < lsTask.size(); j++){
                 if (lsTask.get(j).number == i ) {
                     lsTask.remove(j);
                     return;
                 }
             }
             System.out.println("no task with this number");

         } // удаление задачи по номеру
         void show(){
             for (int j = 0; j < lsTask.size(); j++){
                 System.out.println(lsTask.get(j).name);
                 System.out.println(lsTask.get(j).number);
                 }
         } // показать все задачи
        void showDetel(){
            int i= 0;
            Scanner in = new Scanner(System.in);
            while ((i <= 0) || (i >= indx)) {
                System.out.println("Task number for detalization");
                String st = in.nextLine();
                try {
                    i = Integer.valueOf(st);
                } catch (NumberFormatException e) {
                    System.err.println("Wrong format");
                }
            }
            for (int j = 0; j < lsTask.size(); j++){
                if (lsTask.get(j).number == i ) {
                    System.out.println(lsTask.get(j).name);
                    System.out.println(lsTask.get(j).number);
                    System.out.println(lsTask.get(j).desc);
                    System.out.println(lsTask.get(j).firstDate);
                    return;
                }
            }
            System.out.println("no task with this number");
        } // показать детали задачи по номеру
        void showDone(){
            for (int j = 0; j < lsTask.size(); j++){
                if (lsTask.get(j).done) {
                    System.out.println(lsTask.get(j).name);
                    System.out.println(lsTask.get(j).number);
                }
            }
        } // показать выполненные задачи
        void showUnDone(){
            for (int j = 0; j < lsTask.size(); j++){
                if (!lsTask.get(j).done) {
                    System.out.println(lsTask.get(j).name);
                    System.out.println(lsTask.get(j).number);
                }
            }
        }// показать невыполненные 
        void taskDone(){
            int i= 0;
            Scanner in = new Scanner(System.in);
            while ((i <= 0) || (i >= indx)) {
                System.out.println("Task number which is done");
                String st = in.nextLine();
                try {
                    i = Integer.valueOf(st);
                } catch (NumberFormatException e) {
                    System.err.println("Wrong format");
                }
            }
            for (int j = 0; j < lsTask.size(); j++){
                if (lsTask.get(j).number == i ) {
                    lsTask.get(j).done = true;
                    return;
                }
            }
            System.out.println("no task with this number");
        } // закрыть задачу по номеру
        void taskFirstdate(){
            String dt = getDate();
            for (int j = 0; j < lsTask.size(); j++){
                if (lsTask.get(j).firstDate == dt ) {
                    System.out.println(lsTask.get(j).name);
                }
            }
        }  // вывести по дате создания
        void taskEnddate(){
            String dt = getDate();
            for (int j = 0; j < lsTask.size(); j++){
                if (lsTask.get(j).endDate == dt ) {
                    System.out.println(lsTask.get(j).name);
                }
            }
        } //ввывести все по дате окончания
    }
    public static void main(String[] args) {
        Schedule sch = new Schedule();
        Scanner in = new Scanner(System.in);

       while(true){
           System.out.println("1 - add task");
           System.out.println("2 - delete task");
           System.out.println("4 - show names of all tasks");
           System.out.println("5 - mark task is done"); // отметить номер сделанной задачи
           System.out.println("6 - show list of all done tasks");
           System.out.println("7 - show list of all udone tasks");
           System.out.println("8 - show list of all tasks, created on particular creation date"); 
           System.out.println("9 - show list of all tasks, created on particular end date");
           System.out.println("10 - show detail for task");
           String men = in.nextLine();
           if (men.equals("1")){
               sch.add();
           }
           if (men.equals("2")) {
               sch.del();
           }
           if (men.equals("4")) {
               sch.show();
           }
           if (men.equals("5")) {
               sch.taskDone();
           }
           if (men.equals("6")) {
               sch.showDone();
           }
           if (men.equals("7")) {
               sch.showUnDone();
           }
           if (men.equals("8")) {
               sch.taskFirstdate();
           }
           if (men.equals("9")) {
               sch.taskEnddate();
           }
           if (men.equals("10")) {
               sch.showDetel();
           }


       }
    }

}