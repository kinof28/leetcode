from typing import List


class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        # Selection sort:
        # n = len(nums)
        # for i in range(n-1):
        #     min = i
        #     for j in range(i+1, n):
        #         if (nums[min] > nums[j]):
        #             min = j
        #     (nums[min], nums[i]) = (nums[i], nums[min])
        # ---------------------------------
        # Heap Sort:
        def heapify(length: int, index: int):
            nonlocal nums
            largest = index
            left = index*2+1
            right = index*2+2
            if (left < length and nums[left] > nums[largest]):
                largest = left
            if (right < length and nums[right] > nums[largest]):
                largest = right
            if (largest != index):
                (nums[index], nums[largest]) = (nums[largest], nums[index])
                heapify(length, largest)

        n = len(nums)
        # heapify the non leafs
        # starting from the last one
        for i in range(int(n/2)-1, -1, -1):
            heapify(n, i)
        # take the root and replace it with the last element
        for i in range(n-1, 0, -1):
            (nums[i], nums[0]) = (nums[0], nums[i])
            heapify(i, 0)
        return nums
