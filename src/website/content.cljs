(ns website.content)

(defn separator
  "Separates components. Takes id so the section is not hidden by menu."
  [id]
  [:div {:class "level"
         :id id}
   [:h5 {:class "is-size-5 is-invisible"}
    id]])

; Navbar
(defn top-nav
  "Top navigation bar with current page name and other pages."
  []
  [:nav {:class      "navbar is-fixed-top is-dark"
         :role       "navigation"
         :aria-label "main navigation"}
   [:div {:class "container"}
    [:div {:class "navbar-brand"}
     [:a {:class "navbar-item"
          :href "/"} "Sammy Shea"]
     [:span {:class       "navbar-burger burger"
             :data-target "menu"}
      ;; spans needed for burger
      [:span][:span][:span]]]

    [:div {:id    "menu"
           :class "navbar-menu"}
     [:div {:class "navbar-start"}
      [:a {:class "navbar-item"
            :href "#overview"} "Overview"]
      [:a {:class "navbar-item"
           :href  "#projects"} "Projects"]
      [:span {:class "navbar-item"}
       [:a {:class "button is-inverted"
            :target "_blank"
            :href "https://github.com/sgshea/"}
        [:span {:class "icon"}
         [:i {:class "fab fa-github"}]]
        [:span "My Github"]]]]]]]
  )

(defn overview
  "Main content for the main page."
  []
  [:div
   [:h1 "This is my website, built in clojurescript"]
   [:p "I am a student at North Carolina State University studying computer science."]])

(defn projects
  "Contains my projects."
  []
  [:div {:class "container"}
   ])


