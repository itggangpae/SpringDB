package mybatis.service.impl;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mybatis.domain.Good;
import mybatis.service.GoodService;

@Service
public class GoodServiceImpl implements GoodService {
	// @Autowired
	// private GoodDao goodDao;

	@Autowired
	private GoodMapper goodDao;

	public void getList() {
		List<Good> list = goodDao.getList();
		for (Good good : list) {
			System.out.println(good);
		}
	}

	public void codeSearch() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("검색할 코드를 입력하세요(종료는 -1):");
			String input = sc.nextLine();
			int code = -1;
			try {
				code = Integer.parseInt(input);
			} catch (Exception e) {
				System.out.println("코드는 숫자로 입력하세요!!!!");
				continue;
			}

			if (code == -1) {
				break;
			}
			Good good = goodDao.codeSearch(code);
			if (good == null) {
				System.out.println("없는 코드 번호입니다.");
			} else {
				System.out.println(good);
			}
		}
		sc.close();
	}

	public void insertGood() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("삽입할 코드를 정수로 입력하세요(종료는 -1):");
			String input = sc.nextLine();
			int code = -1;
			try {
				code = Integer.parseInt(input);
			} catch (Exception e) {
				System.out.println("코드는 숫자로 입력하세요!!!!");
				continue;
			}

			if (code == -1) {
				break;
			}

			Good good = goodDao.codeSearch(code);
			if (good == null) {
				System.out.print("이름을 입력하세요:");
				String name = sc.nextLine();
				System.out.print("삽입할 원산지를 입력하세요:");
				String manufacture = sc.nextLine();
				System.out.print("삽입할 가격를 입력하세요:");
				String price = sc.nextLine();
				Good insert = new Good(code, name, manufacture, Integer.parseInt(price));

				int r = goodDao.insertGood(insert);
				if (r > 0)
					System.out.println("삽입 성공");
				else
					System.out.println("삽입 실패");
				break;
			} else {
				System.out.println("이미 존재하는 코드 번호 입니다.");
				continue;
			}
		}
		sc.close();
	}

	public void deleteGood() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("삭제할 코드를 정수로 입력하세요(종료는 -1):");
			String input = sc.nextLine();
			int code = -1;
			try {
				code = Integer.parseInt(input);
			} catch (Exception e) {
				System.out.println("코드는 숫자로 입력하세요!!!!");
				continue;
			}

			if (code == -1) {
				break;
			}

			int r = goodDao.deleteGood(code);
			if (r != 0)
				System.out.println("삭제 성공");
			else
				System.out.println("삭제 실패");
			break;
		}
		sc.close();
	}

	public void updateGood() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("수정할 코드를 정수로 입력하세요(종료는 -1):");
			String input = sc.nextLine();
			int code = -1;
			try {
				code = Integer.parseInt(input);
			} catch (Exception e) {
				System.out.println("코드는 숫자로 입력하세요!!!!");
				continue;
			}

			if (code == -1) {
				break;
			}

			Good good = goodDao.codeSearch(code);
			if (good != null) {
				System.out.print("수정핡 이름을 입력하세요:");
				String name = sc.nextLine();
				System.out.print("수정할 원산지를 입력하세요:");
				String manufacture = sc.nextLine();
				System.out.print("수정할 가격를 입력하세요:");
				String price = sc.nextLine();
				Good update = new Good(code, name, manufacture, Integer.parseInt(price));

				int r = goodDao.updateGood(update);
				if (r > 0)
					System.out.println("수정 성공");
				else
					System.out.println("수정 실패");
				break;
			} else {
				System.out.println("존재하지 않는 코드 번호 입니다.");
				continue;
			}
		}
		sc.close();
	}

}
