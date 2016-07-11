using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Kata
{
    /*
     Your task is to Search a Pattern inside a Text.
    It's not too difficult, but there are some things you have to consider...

    So what to do?

    Input: Text- String, Pattern- String and Behind- Bool (flag for overlapping)
    1. Search the pattern inside the text (always lower case letters splitted by spaces)
    2. Collect all hit positions - add the indexes to a List, always in ascending order
    3. If "Behind" flag is false collect every position overlapping included, if true no overlapping is allowed (next search behind)
    4. If text and/or pattern is empty => empty List
     
    Input: Text= "aabababa baabba aba", Pattern= "aba", Behind=true
    Output: List<int>() {2, 6, 17}

    Input: Text= "aabababa baabba aba", Pattern= "aba", Behind=false
    Output: List<int>() { 2, 4, 6, 17 };

    I think it's clear?!
     */
    public class PatternBehind
    {
        public List<int> searchText(string text, string pattern, bool behind)
        {
            List<int> list = new List<int>();
            if (!String.IsNullOrEmpty(pattern) && !String.IsNullOrEmpty(text))
            {
                Regex num = new Regex(pattern);
                foreach (Match match in Regex.Matches(text, pattern))
                {
                    list.Add(match.Index);
                    int currentIndex = match.Index;
                    if (!behind && text.Length - (match.Index + (pattern.Length - 1)) >= pattern.Length)
                    {
                        if (currentIndex != match.Index + (pattern.Length - 1) &&  num.IsMatch(text.Substring(match.Index + (pattern.Length - 1), pattern.Length)))
                        {
                            list.Add(match.Index + (pattern.Length - 1));
                        }
                        
                    }
                }
            }
            return list;
        }
    }
}
