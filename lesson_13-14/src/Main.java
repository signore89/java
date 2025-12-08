//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Student student1 = new Student("Батодалаев","Даши",16,"ГК"
                                    ,"Web_011",5);
    student1.info();
    Student student2 = new Student("Загидуллин","Линар",32,"РПО"
            ,"PD_011",5);
    student2.info();

    Teacher teacher1 = new Teacher("Даньшин","Андрей",38,"Астрофизика",110);
    teacher1.info();

    Graduate graduate1 = new Graduate("Шугани","Сергей",15,"РПО", "PD_011",4,"Защита персональных данных");
    graduate1.info();

    Specialist specialist1 = new Specialist(graduate1,5);
    specialist1.info();

}
