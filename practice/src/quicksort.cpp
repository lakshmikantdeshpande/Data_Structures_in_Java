#include <iostream>

using namespace std;

void swap(int *array, int i, int j)
{
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}


int partition(int *array, int start, int end) {
    int pivot = array[end];
    int pindex = start;
    
    for (int i = start; i < end; i++) {
        if (array[i] <= pivot)
        {
            swap(array, i, pindex);
            pindex++;
        }
    }
    swap(array, pindex, end);
    return pindex;
}

void QuickSort(int *array, int start, int end) 
{
    if (start < end)
    {
        int pivot = partition(array, start, end);
        QuickSort(array, start, pivot-1);
        QuickSort(array, pivot+1, end);
    }
}

int main()
{
	int array[] = {1, 33, 4, 46, 3, 36, 345, 343, 6, 346, 43 };
	QuickSort(array, 0, 10);
	for (int i = 0; i < 11; i++)
	{
	    cout << array[i] << " ";
	}
}
