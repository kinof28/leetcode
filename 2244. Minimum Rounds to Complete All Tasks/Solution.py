from typing import List


class Solution:
    def minimumRounds(self, tasks: List[int]) -> int:
        tasks.sort()
        if (len(tasks) == 0):
            return 0
        if (len(tasks) == 1):
            return -1
        repetitions = []

        def isPossibleToComplete(tasks: List[int], repetitions: List[int]) -> bool:
            current = tasks[0]
            sum = 1
            for task in tasks[1:]:
                if (task == current):
                    sum += 1
                else:
                    if (sum == 1):
                        return False
                    repetitions.append(sum)
                    sum = 1
                    current = task
            if (sum == 1):
                return False
            repetitions.append(sum)
            return True

        if (not isPossibleToComplete(tasks, repetitions)):
            return -1
        result = 0
        for repetition in repetitions:
            if (repetition % 3 == 0):
                result += int(repetition/3)
            elif (repetition % 2 == 0):
                while (repetition > 6):
                    result += 2
                    repetition -= 6
                result += int(repetition/2)
            else:
                while (repetition > 2 and repetition != 4):
                    repetition -= 3
                    result += 1
                result += int(repetition/2)
        return result
