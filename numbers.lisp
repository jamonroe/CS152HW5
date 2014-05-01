(define A 1)
;null
(define B 0.1)
;null

(+ 1 (+ 1 1))
;3
(integer? 2)
;t
(integer? 0.2)
;f
(real? 2)
;t
(real? 0.2)
;t
(integer? A)
;t
(integer? B)
;f
(real? A)
;t
(real? B)
;t
(integer? (+ 1 1))
;t
(real? (+ 1 1))
;t
(integer? (+ 1 0.1))
;f
(real? (+ 1 0.1))
;t
(integer? (+ A B))
;f
(real? (+ A B))
;t