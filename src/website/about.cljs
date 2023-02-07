(ns website.about
  (:require
   [reagent-mui.material.typography :refer [typography]]
   [reagent-mui.material.box :refer [box]]
   [reagent-mui.material.stack :refer [stack]]
   [reagent-mui.material.paper :refer [paper]]
   [reagent-mui.material.grid :refer [grid]]
   ))

;; Text for easy access
(def about-text
  '("Hi, I'm Sammy"
   "I'm currently a student at North Carolina State University studying computer science. Most of my experience is working in Java but also have worked with C and Clojure."))

;; About content
(defn stack-item
  [text]
  [paper {:elevation 3}
    text])

(defn about
  []
  [box {:sx {:bgcolor "primary.main"}}
   [stack {:spacing 2
           :alignItems "center"
           :m 5}
    (stack-item [typography {:variant :h3
                             :m 3
                             :color "red"}
                 (first about-text)])
    (stack-item [typography {:variant :h6
                             :m 5}
                 (second about-text)])]])

;; Technologies grid
(def technologies-info
  {:Languages '("Java" "Clojure" "C")
   :Libraries '("JUnit" "Spring" "JavaFX" "Reagent")
   :Cli-tools '("git" "bash/zsh")
   :Operating-systems '("Fedora Linux" "Windows Subsystem for Linux" "Windows")
   :Editors '("Eclipse" "VS Code" "Intellij" "vim/neovim")
   :Other '("MySQL")})

(defn tech-item-category
  [item]
  [grid {:item true
         :xs 6}
   [paper {:elevation 5}
    [typography {:variant :h6
                 :m 2}
     item]]])

(defn tech-item
  [item]
  [grid {:item true
         :xs 4}
   [paper {:elevation 2}
    [typography {:variant :subtitle1
                 :m 1}
     item]]])

(defn tech-category
  [items]
  [grid {:container true
         :spacing 1
         :alignItems "center"
         :justifyContent "center"
         :backgroundColor "primary.main"}
   (tech-item-category (key items))
   (map tech-item (val items))])

(defn technologies
  []
  [box {:sx {}}
   [stack {:spacing 1}
    [box]
    (map tech-category technologies-info)]])