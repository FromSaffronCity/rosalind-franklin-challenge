def fibonacci_numbers(n):
    if (n == 1) or (n == 2):
        return 1
    temp_1 = 1
    temp_2 = 1

    for i in range(3, n+1):
        temp = temp_2
        temp_2 = temp_1+temp_2
        temp_1 = temp
    return temp_2


def insertion_sort(array):
    number_of_swaps = 0

    for i in range(1, len(array)):
        for j in range(i, 0, -1):
            if array[j] < array[j-1]:
                temp = array[j]
                array[j] = array[j-1]
                array[j-1] = temp
                number_of_swaps += 1
            else:
                break
    return number_of_swaps


def binary_search(array, key):
    low = 0
    high = len(array)-1

    while low <= high:
        mid = (low+high)//2

        if array[mid] == key:
            return mid+1
        elif array[mid] < key:
            low += 1
        else:
            high -= 1
    else:
        return -1


def merge_two_sorted_arrays(array1, array2):
    index1 = index2 = 0
    merged_array = []

    while (index1 < len(array1)) and (index2 < len(array2)):
        if array1[index1] < array2[index2]:
            merged_array.append(array1[index1])
            index1 += 1
        else:
            merged_array.append(array2[index2])
            index2 += 1
    else:
        if index1 == len(array1):
            for i in range(index2, len(array2)):
                merged_array.append(array2[i])
        if index2 == len(array2):
            for i in range(index1, len(array1)):
                merged_array.append(array1[i])
    return merged_array
