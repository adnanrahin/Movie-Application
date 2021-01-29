import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {CategoryService} from '../../services/category.service';
import {Category} from '../../model/category';

@Component({
  selector: 'app-filter-category',
  templateUrl: './filter-category.component.html',
  styleUrls: ['./filter-category.component.css']
})
export class FilterCategoryComponent implements OnInit {

  constructor(private categoryService: CategoryService) {
    this.checkedList = [];
  }

  @Input() list: any[];
  @Output() shareCheckedList = new EventEmitter();
  @Output() shareIndividualCheckedList = new EventEmitter();

  allCategory: Category[] = [];
  checkedList: any[];
  currentSelected: {};

  // tslint:disable-next-line:typedef
  showDropDown: boolean;

  ngOnInit(): void {
    this.getAllCategory();
  }

  // tslint:disable-next-line:typedef
  public getAllCategory() {
    this.categoryService.getAllCategory().subscribe(data => {
      this.allCategory = data;
    });
  }

  // tslint:disable-next-line:typedef
  getSelectedValue(value: string) {
    console.log(value);
    if (status) {
      this.checkedList.push(value);
    } else {
      // tslint:disable-next-line:prefer-const
      let index = this.checkedList.indexOf(value);
      this.checkedList.splice(index, 1);
    }

    this.currentSelected = {checked: status, name: value};

    // share checked list
    this.shareCheckedlist();

    // share individual selected item
    this.shareIndividualStatus();
  }

  // tslint:disable-next-line:typedef
  shareCheckedlist() {
    this.shareCheckedList.emit(this.checkedList);
  }

  // tslint:disable-next-line:typedef
  shareIndividualStatus() {
    this.shareIndividualCheckedList.emit(this.currentSelected);
  }


}
