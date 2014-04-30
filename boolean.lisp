(define A "STRING")
;null
(define B #t)
;null

(boolean? 0)
;f
(boolean? '())
;f
(boolean? "String")
;f
(boolean? A)
;f
(boolean? B)
;t
(boolean? 'B)
;f
(boolean? #f)
;t