import csv
from Note import Note

class LoadSave:

    def save(list_of_note):
        file = input(
            "Введите название файла для сохранения (формат: имя файла.csv): ")
        with open(file, 'w', newline='') as f:
            write = csv.writer(f)
            write.writerow(list_of_note)
        print(f'Данные сохранены в файл {file}')

    def load(list_of_note):
        try:
            file = input(
                "Введите название файла для загрузки (формат: имя файла.csv): ")
            newlist = []
            with open(file, 'r', newline='') as f:
                w = csv.reader(f, delimiter=',')
                for row in w:
                    for i in range(len(row)):
                        newlist.append(row[i])

            for i in range(len(newlist)):
                text_of_note = str((str(newlist[i]).split('\n'))[0]).split(';')
                new_note = Note(text_of_note[1], text_of_note[2])
                new_note.set_id(text_of_note[0])
                new_note.change_date_of_create(text_of_note[3])
                new_note.change_time_of_create(text_of_note[4])
                new_note.change_date_of_change(text_of_note[5])
                new_note.change_time_of_change(text_of_note[6])
                list_of_note.append(new_note)
            print(f'Данные из файла {file} загружены ')
        except:
            print("Ошибка в наименовании файла, дибо файл пустой!")
