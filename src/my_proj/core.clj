(ns my-proj.core
  (:gen-class))

(def total-de-vidas 6)

(defn perdeu []
  (println "Voce perdeu"))

(defn ganhou []
  (println "Voce ganhou"))

(defn letras-faltantes [palavra acertos]
  (remove (fn [letra] (contains? acertos (str letra))) palavra))

(defn acertou-a-palavra-toda? [palavra acertos]
  (print "acertos: ")
  (println acertos)
  (empty? (letras-faltantes palavra acertos)))

(defn le-letra! []
  (println "Tente outra letra")
  (read-line))

(defn acertou? [chute palavra]
  (.contains palavra chute))

(defn avalia-chute [chute vidas palavra acertos]
  (if (acertou? chute palavra)
    (jogo vidas palavra (conj acertos chute))
    (jogo (dec vidas) palavra acertos)))

(defn jogo [vidas palavra acertos]
  (if (= vidas 0)
    (perdeu)
    (if (acertou-a-palavra-toda? palavra acertos)
      (ganhou)
      (avalia-chute (le-letra!) vidas palavra acertos))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

;; comment test
