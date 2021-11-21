# Fluid Simulation

**Currently imitates very basic fluid simulation in 2-D**

##Paper
**[Reference paper by Mike Ash](https://mikeash.com/pyblog/fluid-simulation-for-dummies.html)**

##Main functions

###diffuse
Put a drop of soy sauce in some water, and you'll notice that it doesn't stay still, but it spreads out. This happens even if the water and sauce are both perfectly still. This is called diffusion. We use diffusion both in the obvious case of making the dye spread out, and also in the less obvious case of making the velocities of the fluid spread out.

###project
The amount of fluid in each box has to stay constant. That means that the amount of fluid going in has to be exactly equal to the amount of fluid going out. The other operations tend to screw things up so that you get some boxes with a net outflow, and some with a net inflow. This operation runs through all the cells and fixes them up so everything is in equilibrium.

###advect
Every cell has a set of velocities, and these velocities make things move. This is called advection. As with diffusion, advection applies both to the dye and to the velocities themselves.

###set_bnd 
his is short for "set bounds", and it's a way to keep fluid from leaking out of your box. Not that it could really leak, since it's just a simulation in memory, but not having walls really screws up the simulation code. Walls are added by treating the outer layer of cells as the wall. Basically, every velocity in the layer next to this outer layer is mirrored. So when you have some velocity towards the wall in the next-to-outer layer, the wall gets a velocity that perfectly counters it.

###lin_solve 
It's used for both diffuse and project. It's solving a linear differential equation of some sort.