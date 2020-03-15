package kz.iitu.remont.designPatterns.StatePattern;

import kz.iitu.remont.entities.Reapirier;

public class Available implements ReparierStates {
    @Override
    public void AvailableRep(Reapirier r) {
        System.out.println("Repariers is already available ");
    }

    @Override
    public void NotAvailableRep(Reapirier r) {
        r.setPs(new NotAvailable());

    }

}
