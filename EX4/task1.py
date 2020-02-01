import os
import threading
import time

tickis=30
lock=threading.Lock()

def sale_tickis(thread_name):
    global tickis
    global lock
    while 1:
        lock.acquire()
        if tickis!=0:
            tickis-=1
            print(thread_name,"余票为：",tickis)
            #time.sleep(0.1)
        else:
            print(thread_name,"票卖完了")
            os._exit(0)

        lock.release()
        time.sleep(0.1)
class my_thread(threading.Thread):

    def __init__(self,name=""):
        threading.Thread.__init__(self)
        self.name=name
    def run(self):
        sale_tickis(self.name)

if __name__=="__main__":
    thread1 = my_thread("线程1")
    thread2 = my_thread("线程2")
    thread3 = my_thread("线程3")
    thread4 = my_thread("线程4")
    thread2.start()
    thread1.start()
    thread3.start()
    thread4.start()
