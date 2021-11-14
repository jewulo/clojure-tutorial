
;;;;;; https://www.youtube.com/watch?v=2Fuvrlym1Lw

;; keywords start with : (they can be defined by programmers)
:keyword
:nextkey
;; vector
(vector 1 2 3)
[1 2 3]
;; list
(list 1 2 3)
'(1 2 3)
;; maps/associated lists
{:foo 1 :bar 2}
(keys {:foo 1 :bar 2})
(vals {:foo 1 :bar 2})
; function invoke
(+ 1 2)
(+ 1 2 3 4 5 6)
;; symbols
'foo+bar
'foo&bar
'foo!
'<foo>
;; function literals
#(+ % 5)
(#(+ % 5) 3)
;; conditionals
(if true :true :false)
(if false :true :false)
(range 5)
(range 1 5)
(inc 7)
(dec 7)
(range 10)
;; map filter reduce
;; map
(map inc (range 10))
(map #(+ % 1) (range 10))
(map + (range 10) (range 10))
(map + (range 10) (range 10) (range 10))
;; filter
(filter even? (range 10))
;; reduce
(reduce + 0 (range 10))
;; let block
(let [a 1
      b 2]
     (+ a b))
(let [a 1
      b (+ a 1)]
     (+ a b))
(let [square #(* % %)
      nonneg-ints (range)
      squares (map square nonneg-ints)
      odd-squares (filter odd? squares)
      first-10 (take 10 odd-squares)
      sum (reduce + 0 first-10)]
     sum)
;; using the treading macro ->>
; also called tread last macro ->>
; or called a transducer
(->> (range)
     (map #(* % %))
     (filter odd?)
     (take 10)
     (reduce + 0))
;; definitions
(def v [1 2 3])
v
(def square #(* % %))
(square 5)
(def square (fn [x] (* x x)))
(square 5)
(define square [x] (* x x))
(square 5)
;; immutability
(conj v 4)
v
(def hm {:foo 1 :bar 2}) ; hm is a hash-map of keys and values
hm
(assoc hm :baz 3)
hm
(dissoc hm :bar 2)
hm
(update hm :bar inc)
hm
; a hash-map can be invoked like a function. its parameters are its keywords
(hm :foo)
(hm :bar)
(map hm [:foo :bar])
; keywords can also be invoked as a function. its parameter is its hash-map
(:foo hm)
(:bar hm)
; hash-map in let block
(let [jeff {:name "Jeff" :age 37 :adult? true}
      jane {:name "Jane" :age  4 :adult? false}
      people [jeff jane]]
     (filter :adult? people))
; hash-map as dictionary
(let [nickname {"Jeffery" "Jeff"
                "Jessica" "Jess"}]
     (map nickname ["Jeffery" "Jessica" "Johann"]))
;; anonymous functions
(#(+ % 1) 2)
(#(+ % % 1) 2)
;; anonymous functions with multiple parameters
(#(+ %1 %2 1) 1 2)
;; function docs
(defn sqr
     "Returns the product of the number 'x' with itself"
     [x]
     (* x x))
(doc sqr)

(defn co2-estimate
     " Returns a conservative years estimate of carbon dioxide parts per million in the atmosphere"
     [year]
     (let [estimate (+ 382 (* 2 (- year 2006)))]
          estimate))
(doc co2-estimate)

(clojure.string/replace "Hello World" #"\w" "!")
(clojure.string/replace "Hello World" #"\w" (fn [letter] (do (println letter) "!")))
(char-array "a")
(first (char-array "a"))
(int (first (char-array "a")))
(Math/pow (int (first (char-array "a"))) 2)