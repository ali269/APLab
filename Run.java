public class Run {
    public static void main(String[] args){
        Student std1 = new Student("ehsan", "edalat", "9031066");
        Student std2 = new Student("Seyyed", "Ahmadpanah", "9031806");
        Student std3 = new Student("ehsan", "edalat", "9031054");
        std1.print();
        std1.setGrade(15);
        std1.print();
        std2.print();
        std2.setGrade(15);
        std2.print();
        std3.print();
        std3.setGrade(15);
        std3.print();
    }
}
