import os
import time
import threading

balance = 1000
lock = threading.Lock()
def withdraw():
    global balance
    balance = balance - 100


def run_thread(thread_name):
    for i in range(10000):
        lock.acquire()
        if balance > 0:
            withdraw()
            print(thread_name,"取走100,还剩",balance)
        else:
            print("没钱了")
            os._exit(0)

        lock.release()
        time.sleep(0.1)
class my_thread(threading.Thread):

    def __init__(self,name=""):
        threading.Thread.__init__(self)
        self.name=name
    def run(self):
        run_thread(self.name)

if __name__ == "__main__":
    t1 = my_thread("张三在柜台")
    t2 = my_thread("李四在ATM")
    t1.start()
    t2.start()