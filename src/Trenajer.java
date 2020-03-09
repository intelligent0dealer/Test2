public class Trenajer {
    int time = 0; // 1 секунда = 4 тика
    int speed = 0;
    // int mode=0;
    boolean walk = true;
    boolean zoomer = false;
    int lock_speed_time = 0;

    public void change_speed(int new_speed) {
        if (!walk && lock_speed_time == 0 && new_speed > 0 && new_speed <= 3) {
            speed = new_speed;
            lock_speed_time = 60*4;
        }
        else if (walk)
            speed = 0;
    }

    public void change_mode() {
        walk = !walk;
        if (walk)
            change_speed(0);
    }

    public void add_time() {
        time += 60*4;
    }

    public void timer_tick() { // Один тик таймера = 1/4 секунды
        if (time > 0) {
            time--;
            if (time % (4 - speed) == 0) {
                zoomer = true;
                zoomer = false;
            }
        }
        if (lock_speed_time > 0)
            lock_speed_time--;
    }
}




