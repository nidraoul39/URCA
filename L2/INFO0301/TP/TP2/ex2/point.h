#ifndef POINT
#define POINT
struct point{
    double x;
    double y;
};
typedef struct point point ;
double distanceorigin(point p);
double distance2point(point p1,point p2);

#endif