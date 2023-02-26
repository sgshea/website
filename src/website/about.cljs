(ns website.about
  (:require
   [reagent-mui.material.typography :refer [typography]]
   [reagent-mui.material.box :refer [box]]
   [reagent-mui.material.stack :refer [stack]]
   [reagent-mui.material.paper :refer [paper]]
   [reagent-mui.material.accordion :refer [accordion]]
   [reagent-mui.material.accordion-details :refer [accordion-details]]
   [reagent-mui.material.accordion-summary :refer [accordion-summary]]
   [reagent-mui.icons.expand-more :refer [expand-more]]
   [reagent-mui.material.linear-progress :refer [linear-progress]]
   [reagent.core :as r]))

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
  [box {:style {:width "90%"}
        :id "about"}
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

;; Technologies information
;; information here is mapped into the individual items, this is the data
(def technologies-info
  [{:name "Programming Languages"
          :list {:Java {:familiarity 100
                        :info "Java is a popular object-oriented language."
                        :desc "This is the programming language I have the most experience
                               in, with almost 3 years of learning within class settings alone."}
                 :Clojure {:familiarity 70
                           :info "Clojure is a dynamic, functional dialect of lisp which runs on many
                                  different platforms such as Java's JVM and browsers through JavaScript."
                           :desc "I have about a year of experience using Clojure and ClojureScript through
                                  using it personally to create projects and experience concepts such as
                                  functional programming."}
                 :C {:familiarity 60
                     :info "C is a low-level systems programming language used for operating systems and embedded applications."
                     :desc "Through university, I have used the C programming language to learn about low-level programming concepts
                            such as memory management and interfacing with the POSIX operating systems API."}
                 :JavaScript {:familiarity 30
                              :info "JavaScript is a dynamic programming language used for website interactivity and other high-level applications."
                              :desc "I have the occasional experience using JavaScript, usually in order to interface with the browser and pass
                                     information to back-end APIs using HTTP requests."}}}
   {:name "Editors"
             :list {:Eclipse {:familiarity 90
                              :info "Eclipse is an integrated development environment used primarily for Java development."
                              :desc "Eclipse is the preferred development environment many of the classes at my university.
                                     I have about 2 years experience using Eclipse for developing, debugging, and testing Java
                                     applications."}
                    :VSCode {:familiarity 100
                             :info "Visual Studio Code is a code editor heavily focused on using plugins to support many languages."
                             :desc "Visual Studio Code is my preferred development environment for Clojure and when trying out other
                                    languages and tools for which a dedicated environment is not immediately"}}}
   {:name "Libraries and Frameworks"
    :list {:JUnit {:familiarity 100
                   :info "JUnit is a unit testing framework for the Java programming language."
                   :desc "Testing practices and test-driven-development has been a heavy focus throughout courses
                          at NC State and we have been exposed to JUnit for Java."}
           :Spring {:familiarity 60
                    :info "Spring Boot is a framework for Java to create web apps."
                    :desc "Spring Boot is used as the backend for course projects in the 'Software Engineering' course
                           and we have used Spring to manage connectivity between the Java backend and JavaScript frontend's
                           HTTP requests."}
           :JavaFX {:familiarity 50
                    :info "JavaFX is a cross-platform graphics library which is used by Java applications."
                    :desc "JavaFX was used for a short period in a course and I used it for the 'Tic-Tac-Toe' application
                           through the wrapper library 'CljFX'."}
           :Reagent {:familiarity 80
                     :info "Reagent is an interface between ClojureScript and the popular JavaScript framework 'React'."
                     :desc "Reagent has been used for this website and other projects that I have written in ClojureScript."}
           :AngularJS {:familiarity 30
                       :info "AngularJS is a recently discontinued JavaScript framework that is the precursor to Angular."
                       :desc "AngularJS is used in the 'Software Engineering' course in order to develop webpages and frontend
                              connection to the backend APIs of the projects."}}}
   {:name "Other Tools"
    :list {:Git-GitHub {:familiarity 100
                        :info "Git is a distributed version control software and GitHub is a hosting
                               service for Git."
                        :desc "Git and GitHub has been used for almost every personal and university project."}
           :MySQL {:familiarity 40
                   :info "MySQL is a relational database management system."
                   :desc "MySQL and general SQL syntax has been used and subject of the 'Software Engineering'
                          course's projects."}}}
   ])

(defn tech-item-accordion
  [[key item]]
  [accordion
   [accordion-summary {:expand-icon (r/as-element [expand-more])
                       :aria-controls "panelia-content"
                       :id (str key "-content")}
    [box {:sx {:width "100%"}}
     [typography {:variant :h7
                 :m 1}
     key]
     [linear-progress {:variant "determinate"
                       :value (:familiarity item)}]]
    ]
   [accordion-details
    [typography {:variant :subtitle1
                 :color :text.primary}
     (:info item)]
    [:br]
    [typography {:variant :body1
                 :color :text.secondary}
     (:desc item)]
    ]]
  )

(defn tech-category
  [category]
  [paper {:elevation 5}
   [typography {:variant :h4
                :color "text.primary"
                :text-align "center"}
    (:name category)]
   (map tech-item-accordion (:list category))])

(defn technologies
  []
  [box {:width "90%"
        :mt 10
        :mb 10
        :id "skills"}
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