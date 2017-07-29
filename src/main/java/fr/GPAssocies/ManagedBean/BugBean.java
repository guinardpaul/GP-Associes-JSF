package fr.GPAssocies.ManagedBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.joda.time.LocalDate;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.GPAssocies.Service.BugService;
import fr.GPAssocies.entities.Bug;

@Component
@ManagedBean
@ViewScoped
public class BugBean {
	@Autowired
	private BugService bugService;
	private Bug bug = new Bug();
	private List<Bug> bugs = new ArrayList<Bug>();

	public BugService getBugService() {
		return bugService;
	}

	public void setBugService(BugService bugService) {
		this.bugService = bugService;
	}

	public Bug getBug() {
		return bug;
	}

	public void setBug(Bug bug) {
		this.bug = bug;
	}

	public List<Bug> getBugs() {
		return bugs;
	}

	public void setBugs(List<Bug> bugs) {
		this.bugs = bugs;
	}

	// Méthodes
	public List<Bug> getAllBug() {
		return bugService.findAll();
	}

	public void create() {
		bug.setDateCreation(new LocalDate());
		bugService.create(bug);
		bug = new Bug();
	}

	public void update() {
		bugService.update(bug);
		bug = new Bug();
	}

	public void delete(Bug b) {
		bugService.delete(b);
	}

	// format String to java.util.Date pour affichage Vue Calendar
	public String onDateSelect(SelectEvent event) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
		return format.format(event.getObject());
	}
}
