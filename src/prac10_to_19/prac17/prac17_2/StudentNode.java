package prac10_to_19.prac17.prac17_2;

class StudentNode {
    private Student student;
    private StudentNode prev;
    private StudentNode next;

    public StudentNode(Student student) {
        this.student = student;
        this.prev = null;
        this.next = null;
    }

    public Student getStudent() { return student; }
    public StudentNode getPrev() { return prev; }
    public StudentNode getNext() { return next; }
    public void setPrev(StudentNode prev) { this.prev = prev; }
    public void setNext(StudentNode next) { this.next = next; }
}