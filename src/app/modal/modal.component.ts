import { Component } from "@angular/core";
import { NgbModal } from "@ng-bootstrap/ng-bootstrap";

@Component({
    selector: 'ngbd-modal-generic',
    templateUrl: './modal.component.html'
})

export class NgModalGeneric{


    constructor(private modalService: NgbModal){}

    open(content){
        this.modalService.open(content)
        
      /*  .result.then((result) => {
            
        }); */
    }


}