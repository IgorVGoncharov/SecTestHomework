import datetime as dt
import uuid

class Note:

    def __init__(self, title: str, message: str):
        self.__id = uuid.uuid1()
        self.__title = title
        self.__message = message
        self.__date_of_create = dt.datetime.today().strftime("%d.%m.%Y")
        self.__time_of_create = dt.datetime.today().strftime("%H.%M.%S")
        self.__date_of_change = dt.datetime.today().strftime("%d.%m.%Y")
        self.__time_of_change = dt.datetime.today().strftime("%H.%M.%S")

    def get_id(self):
        return self.__id

    def set_id(self, new_id):
        self.__id = new_id

    def get_title(self):
        return self.__title

    def set_title(self, new_title):
        self.__title = new_title

    def get_message(self):
        return self.__message

    def set_message(self, new_message):
        self.__message = new_message

    def get_date_of_create(self):
        return self.__date_of_create

    def change_date_of_create(self, new_date):
        self.__date_of_create = new_date

    def get_time_of_create(self):
        return self.__time_of_create

    def change_time_of_create(self, new_time):
        self.__time_of_create = new_time

    def get_date_of_change(self):
        return self.__date_of_change

    def set_date_of_change(self):
        self.__date_of_change = dt.datetime.today().strftime("%d.%m.%Y")

    def change_date_of_change(self, new_date):
        self.__date_of_change = new_date

    def get_time_of_change(self):
        return self.__time_of_change

    def set_time_of_change(self):
        self.__time_of_change = dt.datetime.today().strftime("%H.%M.%S")

    def change_time_of_change(self, new_time):
        self.__time_of_change = new_time

    def __repr__(self) -> str:
        return f"{self.__id}; {self.__title}; {self.__message}; {self.__date_of_create}; {self.__time_of_create}; {self.__date_of_change}; {self.__time_of_change}"
