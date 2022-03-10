package subdomain_visit_count

class Solution {
    fun subdomainVisits(cpdomains: Array<String>): List<String> {
        val result = HashMap<String, Int>()

        fun HashMap<String, Int>.add(key: String, value: Int) {
            this.compute(key) { _, v -> (v ?: 0) + value }
        }

        cpdomains.forEach { cpdomain ->
            var (cpStr, domain) = cpdomain.split(" ")
            val cp = cpStr.toInt()

            result.add(domain, cp)
            var index = domain.indexOf('.')
            domain = domain.substring(index + 1 until domain.length)

            result.add(domain, cp)
            index = domain.indexOf('.')
            if (index > 0) {
                domain = domain.substring(index + 1 until domain.length)
                result.add(domain, cp)
            }


        }

        return result.map { (a, b) -> "$b $a" }
    }
}