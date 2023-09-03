(ns website.about)

(defn project-template [id link title text images? images]
   [:div {:class "card container image-full bg-neutral mb-5"}
    [:figure
     [:img {:class "" :src (first images)}]]
    [:div {:class "card-body"}
     [:h2 {:class "card-title"} title]
     text
     [:div {:class "card-actions"}
      [:button {:class "btn btn-secondary"
                :href link}
       [:a {:href link} "GitHub"]
       ;; GitHub button
       [:svg {:xmlns "http://www.w3.org/2000/svg" :fill "bg-primary" :view-box "0 0 24 24" :class "h-6 w-6"}
        [:path {:fill-rule "evenodd" :d "M10 .333A9.911 9.911 0 0 0 6.866 19.65c.5.092.678-.215.678-.477 0-.237-.01-1.017-.014-1.845-2.757.6-3.338-1.169-3.338-1.169a2.627 2.627 0 0 0-1.1-1.451c-.9-.615.07-.6.07-.6a2.084 2.084 0 0 1 1.518 1.021 2.11 2.11 0 0 0 2.884.823c.044-.503.268-.973.63-1.325-2.2-.25-4.516-1.1-4.516-4.9A3.832 3.832 0 0 1 4.7 7.068a3.56 3.56 0 0 1 .095-2.623s.832-.266 2.726 1.016a9.409 9.409 0 0 1 4.962 0c1.89-1.282 2.717-1.016 2.717-1.016.366.83.402 1.768.1 2.623a3.827 3.827 0 0 1 1.02 2.659c0 3.807-2.319 4.644-4.525 4.889a2.366 2.366 0 0 1 .673 1.834c0 1.326-.012 2.394-.012 2.72 0 .263.18.572.681.475A9.911 9.911 0 0 0 10 .333Z"
                :clip-rule "evenodd"}]]]
      (if images?
        [:div
         [:button {:class "btn btn-secondary"
                   :on-click #((-> js/document
                                   (.getElementById id)
                                   (.showModal)))} "Images"]
         [:dialog {:id id :class "modal"}
          [:form {:method "dialog" :class "modal-box max-w-none h-3/5 w-2/3"}
           [:div {:class "flex flex-col w-full"}
            (for [item images]
              [:div
               [:div {:class "divider"}]
               [:img {:src item}]])]
           [:div {:class "modal-action"}
            [:button {:class "btn btn-sm btn-circle btn-secondary absolute right-2 top-2"} "X"]]]
          [:form {:method "dialog" :class "modal-backdrop"}
           [:button "Close"]]]]
        nil)]]])

(defn nav-bar []
  [:div {:class "navbar bg-primary text-primary-content"}
   [:div {:class "flex-1"}
    [:a {:class "btn btn-ghost normal-case text-xl"}
     "Sammy Shea"]]
   [:div {:class "flex-none"}
    [:div {:class "dropdown dropdown-bottom dropdown-end"}
     [:label {:tabIndex "0" :class "btn btn-ghost m-1"} "Projects"]
     [:li {:tabIndex "0" :class "dropdown-content bg-primary menu shadow mt-3 z-[1] p-2 rounded-box w-52"}
      [:ul
       [:li [:a "Rust NEAT"]]
       [:li [:a "Clojure FullStack"]]
       [:li [:a "Portfolio Website"]]
       ]]]]])

(defn main-paragraph []
  [:article {:class "prose mb-10"}
   [:h1
    "About"]
   [:p
    "Hi, my name is Sammy! I currently am studying Computer Science at the University of North Carolina.
     I am interested in open-source spaces such as Linux, as well as topics such as artifical intelligence and exploring different programming languages or paradigms!"]
   ])

(def neat-project
  [project-template
   "RNI"
   "https://github.com/sgshea/neat"
   "Rust NEAT Implementation"
   [:article {:class "prose"}
    [:p "Implementation of the Neuroevolution of Augmenting Topologies (NEAT) machine learning algorithm in the Rust programming language."]
    [:h4 "Problem Statement"]
    [:p "This project was primarily taken on in an interest to learn the Rust language. At the same time as I was going throught the Rust Book,
         I came across the idea of neuroevolution in machine learning. The NEAT algorithm is originally described in a paper from 2002 and focuses
         on evolving neural network structures. There are several different libraries available which implement this and related libraries, but no
         very mature ones for Rust and I had the idea to implement a simple library as a learning experiment."]
    [:p "The library in it's current state implements the paper's ideas as well as some tweaks that are mentioned in newer literature enough to solve
         the basic XOR function. From this project I gained a good understanding of how Rust programs can be structured and of different language elements
         through the couple of rewrites of the project."]] 
   false])

(def clojure-fullstack
  [project-template
   "CFS"
   "https://github.com/sgshea/ecommerce"
   "Clojure Fullstack Ecommerce Application"
   [:article {:class "prose"}
    [:p "Fullstack application written in Clojure/ClojureScript."]
    [:h4 "Main Technologies (Specifics on GitHub)"]
    [:ul
     [:li "Clojure/ClojureScript"]
     [:li "Reagent frontend framework (React Wrapper for ClojureScript)"]
     [:li "MUI component library"]
     [:li "Ring HTTP Server (Based on Eclipse Jetty)"]
     [:li "Reitit routing library, middleware, Swagger API documentation plugin"]
     [:li "SQLite database, using Honey SQL to define SQL queries in Clojure"]
     [:li "Buddy authentication, using Json Web Tokens (JWT)"]
     [:li "Packaged as Dockerfile"]
     ]]
   true
   '("images/ecom_1.png" "images/ecom_2.png" "images/ecom_3.png" "images/ecom_4.png" "images/ecom_5.png" "images/ecom_6.png")])

(def portfolio-website
  [project-template
   "PW"
   "https://github.com/sgshea/website"
   "Portfolio Website"
   [:article {:class "prose"}
    [:p "Static Website Written in ClojureScript."]]
   false])

(defn main []
[:div
 [nav-bar]
 [:div {:class "flex flex-col items-center mt-5"}
  [main-paragraph]
  neat-project
  clojure-fullstack
  portfolio-website
  ]])
