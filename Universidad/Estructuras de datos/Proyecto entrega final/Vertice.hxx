#ifndef VERTICE_XX_H
#define VERTICE_XX_H

#include "vertice.h"
#include <cmath>

std::ostream& operator<<(std::ostream& os, const Vertice& v) {
    os << "(" << v.px << ", " << v.py << ", " << v.pz << ")";
    return os;
}

#endif  // VERTICE_XX_H
