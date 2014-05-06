(define float? 
 (lambda (x) 
 (and (real? x) (not (integer? x))) 
)) 

(float? 3.2)
;t

(float? 1)
;f

(float? #t)
;f

(float? "string")
;f

(float? '())
;f

(define same-type? 
 (lambda (x y) 
	 (or (and (symbol? x) (symbol? y)) 
	 	 (and (integer? x) (integer? y)) 
	     (and (float? x) (float? y)) 
	     (and (boolean? x) (boolean? y)) 
	     (and (char? x) (char? y)) 
	     (and (string? x) (string? y))) 
)) 

(same-type? '() '())
;f

(same-type? 1 3)
;t
(and (integer? 1) (integer? 3))
;t

(same-type? 1.1 3)
;f

(same-type? #t #f)
;t
(and (boolean? #t) (boolean? #f))
;t

(same-type? #\c #\3)
;t
(and (char? #\c) (char? #\3))
;t


