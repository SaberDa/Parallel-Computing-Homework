if __name__ == '__main__':

    def quick_sort(array, left, right):
        if left >= right:
            return
        low = left
        high = right
        key = array[low]
        while left < right:
            while left < right and array[right] > key:
                right -= 1
            array[left] = array[right]
            while left < right and array[left] <= key:
                left += 1
            array[right] = array[left]
        array[right] = key
        quick_sort(array, low, left - 1)
        quick_sort(array, left + 1, high)


    i = 0

    try:
        with open("file_3.txt") as file:
            data = file.read()
            a = data.split(',')
            b = data.split(' ')
            print(a)
            for tempName in a:
                a[i] = int(tempName)
                i = i + 1
    except IOError as e:
        print("File Error:" + str(e))
    print(a)
    quick_sort(a, 0, len(a) - 1)

    filename = 'data1.txt'
    try:
        with open(filename, 'w') as f:
            for t in a:
                s = str(t)
                f.write(s)
                f.write(",")
    except IOError as e:
        print("File Error:" + str(e))
    print(a)