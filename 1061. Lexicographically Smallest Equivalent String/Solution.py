class Solution:
    def smallestEquivalentString(self, s1: str, s2: str, baseStr: str) -> str:
        sets = []

        for c1, c2 in zip(s1, s2):
            added = False
            for s in sets:
                if (c1 in s or c2 in s):
                    s.add(c1)
                    s.add(c2)
                    added = True
            if (not added):
                new_set = set()
                new_set.add(c1)
                new_set.add(c2)
                sets.append(new_set)
        temp_sets = []
        for i, set1 in enumerate(sets):
            for set2 in sets[i:]:
                if (not set1.isdisjoint(set2)):
                    set1 = set1.union(set2)
            temp_sets.append(sorted(set1))
        sets = temp_sets
        result = ""
        for c in baseStr:
            added = False
            for s in sets:
                if (c in s):
                    result += s[0]
                    added = True
                    break
            if (not added):
                result += c
        return result
