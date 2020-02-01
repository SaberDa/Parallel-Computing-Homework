
if __name__=='__main__':
    i=0
    j=0
    try:
        with open("file_1.txt") as file:
            data=file.read()
            a=data.split(',')
            for tempName in a:
                if(tempName=='book'):
                     i=i+1
    except IOError as e:
        print("File Error:" + str(e) )

    print("file_1中有%s个book"%i)

    try:
        with open("file_2.txt") as file:
            data=file.read()
            a=data.split(',')
            for tempName in a:
                if(tempName=='book'):
                    j=j+1
            print("file_2中有%s个book"%j)
    except IOError as e:
        print("File Error:" + str(e))
    print("总共%s个book"%(j+i))
    q=i+j
    str1=str(q)
    filename='1.txt'
    try:
        with open(filename,'w') as f:
            f.write(str1)
    except IOError as e:
        print("File Error:" + str(e))