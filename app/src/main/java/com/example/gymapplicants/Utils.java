package com.example.gymapplicants;

import android.content.Context;

import java.util.ArrayList;

public class Utils {
    private static ArrayList<Training> trainings;
    private static ArrayList<Plans> plans;

    public static void initTraining() {
        if (trainings == null) {
            trainings = new ArrayList<>();
        }
        Training pushup = new Training(1, "Push-Up",
                "A push-up is a common calisthenics exercise beginning from the prone position.",
                " Push-ups are a basic exercise used in civilian athletic training or physical education and commonly in military physical training.",
                "https://www.menshealth.com.au/media/5310/main_0.jpg");
        trainings.add(pushup);
        Training squat = new Training(2,
                "Squat",
                "A squat is a strength exercise in which the trainee lowers their hips from a standing position and then stands back up.",
                "A squat is a strength exercise in which the trainee lowers their hips from a standing position and then stands back up.",
                "https://media1.popsugar-assets.com/files/thumbor/KsnEx7sTQ8PgXIVFgYwCvtCavc0/fit-in/728xorig/filters:format_auto-!!-:strip_icc-!!-/2019/11/21/942/n/40891428/35c2c24f5033318a_tmp_4shQpe_db2c47cab888c16b_goblet_squat_2/i/Squat-Hold-Punches-With-Mini-Band.jpeg");
        trainings.add(squat);
        Training legPress = new Training(3,
                "Leg Press",
                "A straight-knee calf raise is often done using the leg press machine.",
                "A straight-knee calf raise is often done using the leg press machine. The sled is kept nearly locked out and the exerciser is meant to keep the hip and knee joints immobile.",
                "https://d.scdn.gr/images/sku_main_images/006196/6196179/xlarge_20150217120556_viking_hm028.jpeg");
        trainings.add(legPress);
        Training BarbellBenchPress = new Training(4,
                "Barbell bench press",
                "Position yourself on the bench with your feet firmly on the ground and your back flat (the bar...",
                "The bench press is an upper-body weight training exercise in which the trainee presses a weight upwards while lying on a weight training bench.",
                "https://cdn2.omidoo.com/sites/default/files/imagecache/full_width/images/bydate/201603/benchpress.jpg");
        trainings.add(BarbellBenchPress);
        Training deadlift = new Training(5,
                "Dead Lift",
                "The grip strength (finger flexors) and the lower back (erector spinae) work isometrically to keep the bar held in the hands and to keep the spine from rounding.",
                "Deadlift refers to the lifting of dead weight (weight without momentum), such as weights lying on the ground. ",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/be/DerekHummer.JPG/220px-DerekHummer.JPG");
        trainings.add(deadlift);
    }

    public static ArrayList<Training> getTrainings() {
        return trainings;
    }

    public static boolean addPlan(Plans plan) {
        if(plans==null) {
            plans = new ArrayList<>();
        }
        return plans.add(plan);
    }

    public static ArrayList<Plans> getPlans() {
        return plans;
    }

    public static boolean removePlan(Plans plan) {
        return plans.remove(plan);
    }
}
