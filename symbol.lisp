(define A 1)
(define B 'C)

(symbol? 0)
;f
(symbol? '0)
;f
(symbol? "String")
;f
(symbol? A)
;f
(symbol? B)
;t
(symbol? 'A)
;t
