(let* ((a 1) (b a)) (+ a b))
; 2

(let ((x 2) (y 3))
  (let ((x 7)
    (z (+ x y)))
      (* z x)))
; 35

;(let* ((x 1)
;  (y (+ x 1)))
;    (list y x))
; (2 1)