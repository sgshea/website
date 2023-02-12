(ns website.about
  (:require
   [reagent-mui.material.typography :refer [typography]]
   [reagent-mui.material.box :refer [box]]
   [reagent-mui.material.stack :refer [stack]]
   [reagent-mui.material.paper :refer [paper]]
   [reagent-mui.material.grid :refer [grid]]
   [reagent-mui.material.linear-progress :refer [linear-progress]]
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
  [box {:style {:width "60%"}}
   [stack {:spacing 5
           :align-items "center"
           :m 4}
    (stack-item [typography {:variant :h3
                             :m 3
                             :color "text.primary"}
                 (first about-text)])
    (stack-item [typography {:variant :h6
                             :m 5}
                 (second about-text)])
    ]])

;; Technologies grid
(def technologies-info
  {:Languages {:Java 100
               :Clojure 70
               :C 50
               :JavaScript 40}
   :Libraries {:JUnit 100
               :Spring 50
               :JavaFx 90
               :Clojure-Reagent 80}
   :Cli-tools {:git 100
               :bash 90}
   :Operating-systems {:Fedora-Linux 100
                       :Windows 80
                       :Windows-Subsystem-For-Linux 80}
   :Editors {:Eclipse 90
             :VSCode 95
             :Neovim 85
             :Intellij 40}
   :Other {:MySql 40}})

(defn tech-item-category
  [item]
  [grid {:item true
         :xs 7}
   [paper {:elevation 5}
    [typography {:variant :h4
                 :color "text.primary"
                 :m 2}
     item]]])

(defn tech-item
  [item]
  [grid {:item true
         :xs 5}
   [paper {:elevation 2}
    [typography {:variant :subtitle2
                 :m 1}
     (get item 0)]
    [box {:sx {:width "100%"}}
     [linear-progress {:variant "determinate"
                       :value (get item 1)}]]]])

(defn tech-category
  [items]
  [grid {:container true
         :spacing 1
         :align-items "center"
         :justify-content "center"
         :m 5}
   (tech-item-category (key items))
   (map tech-item (val items))])

(defn technologies
  []
  [box {:width "80%"
        :mt 10}
   [stack {:spacing 1
           :align-items "center"}
    [paper {:eleveation 5
            :xs 7}
     [typography {:variant :h3
                  :color "text.primary"
                  :text-align "center"
                  :m 5}
      "Technical Skills"]
     [typography {:variant :subtitle2
                  :color "text.secondary"
                  :text-align "center"
                  :m 5}
      "These are some of my primary technical skills I have aquired so far roughly
       ranked by my familiarity with them. This is not an exhaustive list and may
       not include things I am currently learning!"]
    (map tech-category technologies-info)]]])