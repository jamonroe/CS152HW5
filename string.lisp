(define A "STRING")
;null
(define B 'C)
;null

(string? 0)
;f
(string? '0)
;f
(string? "String")
;t
(string? A)
;t
(string? B)
;f
(string? 'A)
;f
