public enum Day {
    SUNDAY ("Воскресенье"),
    MONDAY ("Понедельник"),
    TUESDAY ("Вторник"),
    WEDNESDAY ("Среда"),
    THURSDAY ("Четверг"),
    FRIDAY ("Пятница"),
    SATURDAY ("Суббота");

    private String title;

    Day(String title) {
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    @Override
    public String toString() {
        return "Day{" +
                "title='" + title + '\'' +
                '}';
    }
}
