from Note import Note


class FunctForNotes:

    def add_new_note(list_of_notes: list):
        temp = True
        while temp:
            print("\nДобавление новой заметки: ")
            new_title = input("    Введите текст заголовка: ")
            new_message = input("    Введите текст заметки: ")
            new_note = Note(new_title, new_message)
            list_of_notes.append(new_note)
            print("\nЗаметка добавлена:")
            FunctForNotes.show_note(new_note)
            temp = FunctForNotes.choise()

    def find_note(list_of_notes: list):
        temp = True
        while temp:
            print("""\nВыберите параметры поиска заметки:
        1. Поиск по тексту из заголовка
        2. Поиск по тексту из заметки
        3. Поиск по дате добавления
        4. Поиск по дате изменения""")
            val = int(input("Введите номер от 1 до 4: "))
            temp_val = 0
            if val == 1:
                text = input("Введите текст из заголовка: ").lower()
                print("\nВ следующих заметках найдены совпадения: ")
                for i in list_of_notes:
                    if text in str(i.get_title()).lower():
                        print(
                            f"Заголовок заметки {list_of_notes.index(i) + 1}: {i.get_title()}")
                        temp_val += 1
                    else:
                        pass
                if temp_val != 0:
                    return True
            elif val == 2:
                text = input("Введите текст из заметки: ").lower()
                print("\nВ следующих заметках найдены совпадения: ")
                for i in list_of_notes:
                    if text in str(i.get_message()).lower():
                        print(
                            f"Заголовок заметки {list_of_notes.index(i) + 1}: {i.get_title()}")
                        temp_val += 1
                    else:
                        pass
                if temp_val != 0:
                    return True
            elif val == 3:
                date_val = input(
                    "Введите дату создания в формате ДД.ММ.ГГГГ: ")
                print("\nВ следующих заметках найдены совпадения: ")
                for i in list_of_notes:
                    if date_val == i.get_date_of_create():
                        print(
                            f"Заголовок заметки {list_of_notes.index(i) + 1}: {i.get_title()}")
                        temp_val += 1
                if temp_val != 0:
                    return True
            elif val == 4:
                date_val = input(
                    "Введите дату изменения в формате ДД.ММ.ГГГГ: ")
                print("\nВ следующих заметках найдены совпадения: ")
                for i in list_of_notes:
                    if date_val == i.get_date_of_change():
                        print(
                            f"Заголовок заметки {list_of_notes.index(i) + 1}: {i.get_title()}")
                        temp_val += 1
                if temp_val != 0:
                    return True
            else:
                print("Введено не верно значение. Попробуйте еще раз.")
                FunctForNotes.find_note(list_of_notes)
            if temp_val == 0:
                print("Заметки по заданным условиям не найдены.")
                temp = FunctForNotes.choise()

    def ShowAllNotes(list_of_notes):
        print("")
        if len(list_of_notes) == 0:
            print("Заметок пока нет")
        else:
            for i in list_of_notes:
                print(f"""ID: {i.get_id()}
Заголовок:              {i.get_title()}
Текст заметки:          {i.get_message()}
Дата создания:          {i.get_date_of_create()}
Время создания:         {i.get_time_of_create()}
Дата корректировки:     {i.get_date_of_change()}
Время корректировки:    {i.get_time_of_change()}
                    """)

    def ChangeSmthInNote(list_of_notes: list):
        temp = True
        while temp:
            note_choise = int(
                input("\nВведите номер заметки, которую Вы хотите отредактировать: "))
            if note_choise < 1 or note_choise > len(list_of_notes):
                print("Ошибка! Такой заметки нет.")
            else:
                print("""\nВыберите, что Вы будете корректировать:
        1. Заголовок заметки
        2. Текст заметки""")
                search_choise = int(input("Введите значение: "))
                if search_choise == 1:
                    new_title = input("\nВведите новый текст заголовка: ")
                    list_of_notes[note_choise-1].set_title(new_title)
                    list_of_notes[note_choise-1].set_date_of_change()
                    list_of_notes[note_choise-1].set_time_of_change()
                    print(f"\nЗаметка изменена: \n")
                    FunctForNotes.show_note(list_of_notes[note_choise-1])
                    temp = FunctForNotes.choise()
                elif search_choise == 2:
                    new_title = input("\nВведите новый текст заметки: ")
                    list_of_notes[note_choise-1].set_message(new_title)
                    list_of_notes[note_choise-1].set_date_of_change()
                    list_of_notes[note_choise-1].set_time_of_change()
                    print(f"\nЗаметка изменена: \n")
                    FunctForNotes.show_note(list_of_notes[note_choise-1])
                    temp = FunctForNotes.choise()
                else:
                    print("Введено не верное значение.")
                    temp = False

    def DelSomeNote(list_of_notes: list):
        temp = True
        while temp:
            note_choise = int(
                input("\nВведите номер заметки, которую Вы хотите удалить: "))
            if note_choise < 1 or note_choise > len(list_of_notes):
                print("Ошибка! Такой заметки нет.")
            else:
                print("\nВы выбрали следующую заметку для удаления:\n")
                FunctForNotes.show_note(list_of_notes[note_choise-1])
                print("Подтвердить удаление - 1\nВыйти в основное меню - 2")
                search_choise = int(input("Введите значение: "))
                if search_choise == 1:
                    list_of_notes.pop(note_choise-1)
                    print("\nЗаметка удалена!")
                    temp = FunctForNotes.choise()
                elif search_choise == 2:
                    temp = False
                    pass
                else:
                    print("Введено не верное значение.")
                    temp = False

    def choise():
        print("\nЕсли хотите повторить - 1\nЧтобы выйти в основное меню - 2")
        val = int(input("Введите значение: "))
        if val == 1:
            return True
        elif val == 2:
            return False
        else:
            print("Введено не верное значение! Попробуйте еще раз.")
            FunctForNotes.choise()

    def show_note(note):
        print(f"""ID: {note.get_id()}
Заголовок:              {note.get_title()}
Текст заметки:          {note.get_message()}
Дата создания:          {note.get_date_of_create()}
Время создания:         {note.get_time_of_create()}
Дата корректировки:     {note.get_date_of_change()}
Время корректировки:    {note.get_time_of_change()}
                    """)
