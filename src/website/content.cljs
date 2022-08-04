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
  [:nav {:class      "navbar is-fixed-top is-primary"
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
      [:div {:class "navbar-item has-dropdown is-hoverable"}
       [:a {:class "navbar-link"} "Projects"]
       [:div {:class "navbar-dropdown"}
        [:a {:class "navbar-item"
             :href "#website-project"} "Website"]]]]
     [:div {:class "navbar-end"}
      [:span {:class "navbar-item"}
       [:a {:class "button is-rounded is-outlined is-dark is-inverted"
            :href "https://github.com/sgshea/"}
        [:span {:class "icon"}
         [:i {:class "fab fa-github"}]]]]
      [:span {:class "navbar-item"}
       [:a {:class "button is-rounded is-outlined is-dark is-inverted"
            :href "https://www.linkedin.com/in/sammy-shea-7350aa1ab"}
        [:span {:class "icon"}
         [:i {:class "fab fa-linkedin"}]]]]]]]]
  )

(defn overview
  "Main content for the main page."
  []
  [:div {:class "container"} 
   [:div {:class "box"}
   [:h1 "About Me"]]
   [:p "I am a second-year student at North Carolina State University studying computer science."]])

(defn website-project
  []
  [:div {:class "container"}
   [:div {:class "box"}
    [:h2 "Projects Showcase"]]
   [:p "These are my projects completed either in class or as personal learning projects"]
   [:div {:class "section"}
     [:div {:class "tile is-ancestor"}
      [:div {:class "tile is-4 is-parent"}
       [:div {:class "tile is-child box"}
        [:h2 "Picture"]
        [:span {:class "image is-32x32"}
         [:img {:src "images/clojurescript_logo.svg"}]]]]
      [:div {:class "tile is-parent"}
       [:div {:class "tile is-child box"}
        [:div {:class "content"}
         [:div {:class "columns"}
          [:h1 {:class "column"} "Personal Website Project in ClojureScript"] 
          [:a {:class "button is-rounded"
               :href "https://github.com/sgshea/website"}
           [:span {:class "icon"}
            [:i {:class "fab fa-github"}]]]]
         [:dl
          [:dt [:h5 "Project Information"]]
          [:dd "Made during summer 2022 to display personal portfolio and to explore ClojureScript."]
          [:p]
          [:dt [:h5 "Technologies Used"]]
          [:dd
           [:ul
            [:li [:dl
                  [:dt [:a {:href "https://clojurescript.org"} "ClojureScript"]]
                   [:dd [:ul
                         [:li "A varient of the functional language Clojure that compiles to JavaScript."]
                         [:li "ClojureScript was used for this project as a stand-in for JavaScript as I was already learning Clojure at the time."]]]]]
            [:li [:dl
                  [:dt [:a {:href "https://reagent-project.github.io"} "Reagent"]]
                  [:dd [:ul
                        [:li "A library that provides an interface to use the popular JavaScript React.js library in plain ClojureScript syntax."]
                        [:li "Reagent handles the basic parts of the website, including HTML and rendering. In a website that is interactable, Reagent would also manage state and complicated rendering."]]]
                  [:li [:dt [:a {:href "https://bulma.io"} "Bulma"]]
                   [:dd [:ul
                         [:li "CSS library which provides many additional classes for styling HTML."]
                         [:li "Used to create the layout of the website, including the navigation bar, headers, and tiles for project showcases."]]]]]]]]]
                         ]]]]]])


