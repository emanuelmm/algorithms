
class MergeSort {

  static void main(String... args)  {
    def entrada = [9, 4, 1, 8, 7, 3, 5, 2]

    def a = []
    def b = []

    def ordenada = MergeSort.mergeSort(entrada)

    println "Lista ordenada ${ordenada}"
  }

  static def mergeSort(def lista) {

    if (lista.size()==1)
      return lista

    println "lista ${lista}"
    def center = lista.size()/2

    def left = MergeSort.mergeSort(lista[0..center-1])
    def right = MergeSort.mergeSort(lista[center..lista.size()-1])

    MergeSort.merge(left, right)
  }

  static def merge(def left, def right) {
    def retorno = []
    def i = 0
    def j = 0

    while(i<left.size() && j<right.size()) {
      if (left[i] < right[j]) {
        retorno << left[i++]
      } else if (right[j] < left[i] ) {
        retorno << right[j++]
      }
    }

    println "retorno ${retorno}"
    if (i < left.size())
      retorno += left[i..-1]

    if (j < right.size())
      retorno += right[j..-1]

    println "retorno concatenado ${retorno}"

    retorno
  }
}
