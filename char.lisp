(define A #\C)
;null
(define B #t)
;null

(char? 0)
;f
(char? '())
;f
(char? "String")
;f
(char? A)
;t
(char? B)
;f
(char? #\Z)
;t