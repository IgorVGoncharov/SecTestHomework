from Functions import FunctForNotes as ffn
from LoadSave import LoadSave as ls


class MyMenu:

    def __init__(self, list_of_note) -> None:
        self.list_of_note = list_of_note

    def new_menu(self):
        try:
            print("""\nМеню: 
        1. Создать новую заметку
        2. Изменить заметку
        3. Удалить заметку
        4. Найти заметку
        5. Вывести список заметок
        6. Сохранить в файл
        7. Загрузить из файла
        8. Выйти""")
            val = int(input("Введите значение: "))
            if val == 1:
                ffn.add_new_note(self.list_of_note)
                self.new_menu()
            elif val == 2:
                if not ffn.find_note(self.list_of_note):
                    self.new_menu()
                else:
                    ffn.ChangeSmthInNote(self.list_of_note)
                    self.new_menu()
            elif val == 3:
                if not ffn.find_note(self.list_of_note):
                    self.new_menu()
                else:
                    ffn.DelSomeNote(self.list_of_note)
                    self.new_menu()
            elif val == 4:
                ffn.find_note(self.list_of_note)
                self.new_menu()
            elif val == 5:
                ffn.ShowAllNotes(self.list_of_note)
                self.new_menu()
            elif val == 6:
                ls.save(self.list_of_note)
                self.new_menu()
            elif val == 7:
                ls.load(self.list_of_note)
                self.new_menu()
            elif val == 8:
                print("\nДо новых встреч!")
            else:
                print("Введено не верное значение.")
                self.new_menu()
        except:
            print("Ошибка! Введено не число.")
            self.new_menu()
