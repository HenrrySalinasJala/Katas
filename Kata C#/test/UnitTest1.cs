using System;
using System.Collections.Generic;
using Kata;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace test
{

    [TestClass]
    public class UnitTest2
    {
        [TestMethod]
        public void TestMethod1()
        {
            List<int> l = new List<int>() {41, 74, 94, 117, 186, 222 };
            string text = "smnmuwegyfurlgfqmhgdpnlfurlg smnmuwegyfjpflcnpueocideocidfurlgfqmhgdpnlfjpflcnpu furlgfurlgfjpflcnpueocidnuxfzgxrkfjpflcnpu fqmhgdpnlfqmhgdpnl smnmuwegy fqmhgdpnleocideocid fqmhgdpnl fjpflcnpunuxfzgxrkfqmhgdpnlfqmhgdpnlfjpflcnpu";
            string pattern = "flcnp";
            Boolean behind = false;
            var x = new PatternBehind();
            var m = x.searchText(text, pattern, behind);
            //¿ Expected (List Output as String)= 21, 117, 163, 193
            CollectionAssert.AreEqual(l, m);
        }
        [TestMethod]
        public void TestMethod2()
        {
            List<int> l = new List<int>() { 21, 117, 163, 193 };
            string text = "cdaxzl yomqqaawcdaxzlimljxxfnbathluqfcdaxzlyomqqaaw cdaxzlyomqqaaw cdaxzlyomqqaawbathluqfcdaxzlyomqqaawyomqqaawcdaxzlimljxxfn bathluqfyomqqaawpbrzjgyomqqaaw pbrzjgimljxxfn cdaxzl pbrzjgyomqqaawimljxxfn";
            string pattern = "i";
            Boolean behind = false;
            var x = new PatternBehind();
            var m = x.searchText(text, pattern, behind);
            //¿ Expected (List Output as String)= 21, 117, 163, 193
            CollectionAssert.AreEqual(l, m);
        }
        [TestMethod]
        public void TestMethod3()
        {
            List<int> l = new List<int>() { 22,79 };
            string text = "wfzqqwatdipyekeeuh hwlrxgsw phkpupfbsfjamwtwfzqqwatd bsfjamwtvigbafotjphkpupf vrfqetmgl wfzqqwatd";
            string pattern = "r";
            Boolean behind = false;
            var x = new PatternBehind();
            var m = x.searchText(text, pattern, behind);
            //¿ Expected (List Output as String)= 21, 117, 163, 193
            CollectionAssert.AreEqual(l, m);
        }


    }
}
